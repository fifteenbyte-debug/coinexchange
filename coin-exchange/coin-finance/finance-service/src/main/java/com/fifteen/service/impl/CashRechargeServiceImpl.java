package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.alicp.jetcache.AutoReleaseLock;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CashRecharge;
import com.fifteen.domain.CashRechargeAuditRecord;
import com.fifteen.domain.Coin;
import com.fifteen.domain.Config;
import com.fifteen.dto.AdminBankDto;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.AdminBankServiceFeign;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.mapper.CashRechargeAuditRecordMapper;
import com.fifteen.model.CashParam;
import com.fifteen.service.AccountService;
import com.fifteen.service.CashRechargeService;
import com.fifteen.mapper.CashRechargeMapper;
import com.fifteen.service.CoinService;
import com.fifteen.service.ConfigService;
import com.fifteen.vo.CashTradeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【cash_recharge(充值表)】的数据库操作Service实现
 * @createDate 2026-03-24 10:59:51
 */
@Service
public class CashRechargeServiceImpl extends ServiceImpl<CashRechargeMapper, CashRecharge>
        implements CashRechargeService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private CashRechargeAuditRecordMapper cashRechargeAuditRecordMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private AdminBankServiceFeign adminBankServiceFeign;

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private CoinService coinService;

    @CreateCache(name = "CASH_RECHARGE_LOCK:", expire = 100, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH)
    private Cache<String, String> cache;

    /**
     * 条件分页查询
     *
     * @param page      分页参数
     * @param coinId    币种的ID
     * @param userId    用户的Id
     * @param userName  用户的名称
     * @param mobile    用户的手机号
     * @param status    审核的状态
     * @param numMin    充值数量的最小值
     * @param numMax    充值数量的最大值
     * @param startTime 充值的开始时间
     * @param endTime   充值数量的结束时间
     * @return
     */
    @Override
    public Page<CashRecharge> findByPage(Page<CashRecharge> page, Long coinId, Long userId, String userName,
                                         String mobile, Byte status, String numMin, String numMax, String startTime,
                                         String endTime) {
        LambdaQueryWrapper<CashRecharge> cashRechargeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 1 使用用户相关的字段进行查询
        Map<Long, UserDto> basicUsers = null;
        if (userId != null || !StringUtils.isEmpty(userName) || !StringUtils.isEmpty(mobile)) {
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtil.isEmpty(basicUsers)) { // 没有用户
                return page;
            }
            cashRechargeLambdaQueryWrapper.in(CashRecharge::getUserId, basicUsers.keySet()); // 使用用户的信息做条件
        }
        // 添加其他的条件
        cashRechargeLambdaQueryWrapper.eq(coinId != null, CashRecharge::getCoinId, coinId)
                .eq(status != null, CashRecharge::getStatus, status)
                .between(
                        !(StringUtils.isEmpty(numMin) || StringUtils.isEmpty(numMax)),
                        CashRecharge::getNum,
                        new BigDecimal(numMin == null ? "0" : numMin), new BigDecimal(numMax == null ? "0" : numMax)
                )
                .between(
                        !(StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)),
                        CashRecharge::getCreated,
                        startTime, endTime + "23:23:59"
                );
        // 查询
        Page<CashRecharge> pageData = page(page, cashRechargeLambdaQueryWrapper);
        // 获取查询的数据
        List<CashRecharge> records = pageData.getRecords();
        if (!CollectionUtil.isEmpty(records)) {
            if (basicUsers == null) { // 说明前面没有使用用户的信息查询用户
                List<Long> userIds = records.stream().map(cashRecharge -> cashRecharge.getUserId()).collect(Collectors.toList());
                basicUsers = userServiceFeign.getBasicUsers(userIds, null, null);
            }
            Map<Long, UserDto> finalBasicUsers = basicUsers;
            records.forEach(record -> {
                UserDto userDto = finalBasicUsers.get(record.getUserId());
                if (userDto != null) {
                    record.setUsername(userDto.getUsername());
                    record.setRealName(userDto.getRealName());
                }
            });
        }
        return pageData;
    }

    @Override
    public boolean cashRechargeAudit(Long userId, CashRechargeAuditRecord cashRechargeAuditRecord) {
        boolean result = cache.tryLockAndRun(cashRechargeAuditRecord.getId() + "", 300, TimeUnit.SECONDS, () -> {
            Long id = cashRechargeAuditRecord.getId();
            CashRecharge cashRecharge = getById(id);
            if (cashRecharge == null) {
                throw new IllegalArgumentException("充值记录不存在");
            }
            if (cashRecharge.getStatus() == 1) {
                throw new IllegalArgumentException("该充值记录已经审核过了");
            }
            CashRechargeAuditRecord cashRechargeAuditRecordDb = new CashRechargeAuditRecord();
            cashRechargeAuditRecordDb.setAuditUserId(userId);
            cashRechargeAuditRecordDb.setStatus(cashRechargeAuditRecord.getStatus());
            cashRechargeAuditRecordDb.setRemark(cashRechargeAuditRecord.getRemark());
            Integer step = cashRecharge.getStep() + 1;
            cashRechargeAuditRecordDb.setStep(step);

            int insert = cashRechargeAuditRecordMapper.insert(cashRechargeAuditRecordDb);

            if (insert == 0) {
                throw new IllegalArgumentException("审核记录保存失败");
            }
            cashRecharge.setStatus(cashRechargeAuditRecord.getStatus());
            cashRecharge.setAuditRemark(cashRecharge.getAuditRemark());
            cashRecharge.setStep(step);

            if (cashRechargeAuditRecord.getStatus() == 2) {
                updateById(cashRecharge);
            } else {
                boolean isOk = accountService.transferAccountAmount(userId, cashRecharge.getUserId(), cashRecharge.getCoinId(), cashRecharge.getId(), cashRecharge.getNum(), cashRecharge.getFee()
                        , "充值", "recharge_into", 1);
                if (isOk) {
                    cashRecharge.setLastTime(new Date());
                    updateById(cashRecharge);
                }
            }
        });
        return result;
    }

    @Override
    public Page<CashRecharge> findUserCashRecharge(Page<CashRecharge> page, Long userId, Integer status) {
        return page(page, new LambdaQueryWrapper<CashRecharge>().eq(CashRecharge::getUserId, userId)
                .eq(status != null, CashRecharge::getStatus, status));
    }

    @Override
    public CashTradeVo buy(Long userId, CashParam cashParam) {
        //1 校验现金参数
        checkCashParam(cashParam);
        // 2 查询我们公司的银行卡
        List<AdminBankDto> allAdminBanks = adminBankServiceFeign.getAllAdminBanks();
        // 仅仅需要一张银行卡
        AdminBankDto adminBankDto = loadbalancer(allAdminBanks);
        //3 生成订单号\参考号
        String orderNo = String.valueOf(snowflake.nextId());
        String remark = RandomUtil.randomNumbers(6);

        Coin coin = coinService.getById(cashParam.getCoinId());

        if (coin == null) {
            throw new IllegalArgumentException("coinId不存在");
        }
        //cashParam.getMum()这是前端给我们的金额,前端可能因为浏览器的缓存导致价格不准确,因此,我们需要在后台进行计算
        Config buyGCNRate = configService.getConfigByCode("CNY2USDT");
        BigDecimal realMum = cashParam.getMum().multiply(new BigDecimal(buyGCNRate.getValue())).setScale(2, RoundingMode.HALF_UP);
        // 4 在数据库里面插入一条充值的记录

        CashRecharge cashRecharge = new CashRecharge();
        cashRecharge.setUserId(userId);
        // 银行卡的信息
        cashRecharge.setName(adminBankDto.getName());
        cashRecharge.setBankName(adminBankDto.getBankName());
        cashRecharge.setBankCard(adminBankDto.getBankCard());

        cashRecharge.setTradeno(orderNo);
        cashRecharge.setCoinId(cashParam.getCoinId());
        cashRecharge.setCoinName(coin.getName());
        cashRecharge.setNum(cashParam.getNum());
        cashRecharge.setMum(realMum); // 实际的交易金额
        cashRecharge.setRemark(remark);
        cashRecharge.setFee(BigDecimal.ZERO);
        cashRecharge.setType("linepay"); // 在线支付
        cashRecharge.setStatus(0); // 待审核
        cashRecharge.setStep(1);// 第一步

        boolean save = save(cashRecharge);
        if (save) {
            // 5 返回我们的成功对象
            CashTradeVo cashTradeVo = new CashTradeVo();
            // 我们收户的银行卡信息
            cashTradeVo.setAmount(realMum);
            cashTradeVo.setStatus(0);
            cashTradeVo.setName(adminBankDto.getName());
            cashTradeVo.setBankName(adminBankDto.getBankName());
            cashTradeVo.setBankCard(adminBankDto.getBankCard());
            cashTradeVo.setRemark(remark);
            return cashTradeVo;
        }
        return null;
    }

    /**
     * 从一个list 里面随机选一个出来
     *
     * @param allAdminBanks
     * @return
     */
    private AdminBankDto loadbalancer(List<AdminBankDto> allAdminBanks) {
        if (CollectionUtil.isEmpty(allAdminBanks)) {
            throw new RuntimeException("没有发现可用的银行卡");
        }
        int size = allAdminBanks.size();
        if (size == 1) {
            return allAdminBanks.get(0);
        }
        Random random = new Random();
        return allAdminBanks.get(random.nextInt(size));
    }

    private void checkCashParam(CashParam cashParam) {
        @NotNull BigDecimal num = cashParam.getNum(); // 现金充值的数量
        Config withDrowConfig = configService.getConfigByCode("WITH_DROW");
        @NotBlank String value = withDrowConfig.getValue();
        BigDecimal minRecharge = new BigDecimal(value);
        if (num.compareTo(minRecharge) < 0) {
            throw new IllegalArgumentException("充值数量太小");
        }
    }
}




