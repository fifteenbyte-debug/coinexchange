package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Account;
import com.fifteen.domain.CashWithdrawAuditRecord;
import com.fifteen.domain.CashWithdrawals;
import com.fifteen.domain.Config;
import com.fifteen.dto.UserBankDto;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserBankServiceFeign;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.mapper.CashWithdrawAuditRecordMapper;
import com.fifteen.model.CashSellParam;
import com.fifteen.service.AccountService;
import com.fifteen.service.CashWithdrawalsService;
import com.fifteen.mapper.CashWithdrawalsMapper;
import com.fifteen.service.ConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【cash_withdrawals(提现表)】的数据库操作Service实现
 * @createDate 2026-03-24 10:59:51
 */
@Service
public class CashWithdrawalsServiceImpl extends ServiceImpl<CashWithdrawalsMapper, CashWithdrawals>
        implements CashWithdrawalsService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private UserBankServiceFeign userBankServiceFeign;

    @Autowired
    private ConfigService configService;

    @Autowired
    private CashWithdrawAuditRecordMapper cashWithdrawAuditRecordMapper;

    @CreateCache(name = "CASH_WITHDRAWALS_LOCK:", expire = 100, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH)
    private Cache<String, String> lock;
    @Autowired
    private AccountService accountService;

    @Override
    public Page<CashWithdrawals> findByPage(Page<CashWithdrawals> page, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime) {
        Map<Long, UserDto> basicUsers = null;
        LambdaQueryWrapper<CashWithdrawals> queryWrapper = new LambdaQueryWrapper<CashWithdrawals>();
        if (userId != null || !StringUtils.isEmpty(userName) || !StringUtils.isEmpty(mobile)) {
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtil.isEmpty(basicUsers)) {
                return page;
            }
            queryWrapper.in(CashWithdrawals::getUserId, basicUsers.keySet());
        }
        queryWrapper.eq(status != null, CashWithdrawals::getStatus, status);
        queryWrapper.between(StringUtils.isNotEmpty(numMin) || StringUtils.isNotEmpty(numMax), CashWithdrawals::getNum, new BigDecimal(StringUtils.isEmpty(numMin) ? "0" : numMin), new BigDecimal(StringUtils.isEmpty(numMax) ? "0" : numMax));
        queryWrapper.between(StringUtils.isNotEmpty(startTime) || StringUtils.isNotEmpty(endTime), CashWithdrawals::getCreated, startTime, endTime + " 23:59:59");
        Page<CashWithdrawals> pageDate = this.page(page, queryWrapper);
        List<CashWithdrawals> records = pageDate.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            List<Long> userIds = records.stream().map(CashWithdrawals::getUserId).collect(Collectors.toList());
            if (basicUsers == null) {
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
        return pageDate;
    }

    @Override
    public boolean updateWithdrawalsStatus(Long userId, CashWithdrawAuditRecord cashWithdrawAuditRecord) {
        boolean isOk = lock.tryLockAndRun(cashWithdrawAuditRecord.getId() + "", 300, TimeUnit.SECONDS, () -> {
            CashWithdrawals cashWithdrawals = getById(cashWithdrawAuditRecord.getId());
            if (cashWithdrawals == null) {
                throw new IllegalArgumentException("现金审核记录不存在");
            }

            CashWithdrawAuditRecord cashWithdrawAuditRecordNew = new CashWithdrawAuditRecord();
            cashWithdrawAuditRecordNew.setAuditUserId(userId);
            cashWithdrawAuditRecordNew.setRemark(cashWithdrawAuditRecord.getRemark());
            cashWithdrawAuditRecordNew.setCreated(new Date());
            cashWithdrawAuditRecordNew.setStatus(cashWithdrawAuditRecord.getStatus());
            Integer step = cashWithdrawals.getStep() + 1;
            cashWithdrawAuditRecordNew.setStep(step);
            cashWithdrawAuditRecordNew.setOrderId(cashWithdrawals.getId());

            int count = cashWithdrawAuditRecordMapper.insert(cashWithdrawAuditRecordNew);
            if (count > 0) {
                cashWithdrawals.setStatus(cashWithdrawAuditRecord.getStatus());
                cashWithdrawals.setRemark(cashWithdrawAuditRecord.getRemark());
                cashWithdrawals.setLastTime(new Date());
                cashWithdrawals.setAccountId(userId);
                cashWithdrawals.setStep(step);
                boolean updateById = updateById(cashWithdrawals);
                if (updateById) {
                    Boolean isPass = accountService.decreaseAccountAmount(userId, cashWithdrawals.getUserId(), cashWithdrawals.getCoinId(), cashWithdrawals.getId(), cashWithdrawals.getNum(), cashWithdrawals.getFee()
                            , cashWithdrawals.getRemark(), "withdrawals_out", 2);
                }
            }

        });
        return isOk;
    }

    @Override
    public Page<CashWithdrawals> findUserCashRecharge(Page<CashWithdrawals> page, Long userId, Integer status) {
        return page(page, new LambdaQueryWrapper<CashWithdrawals>().eq(CashWithdrawals::getUserId, userId).
                eq(status != null, CashWithdrawals::getStatus, status));
    }

    @Override
    public boolean sell(Long userId, CashSellParam cashSellParam) {
        //1 参数校验
        checkCashSellParam(cashSellParam);
        Map<Long, UserDto> basicUsers = userServiceFeign.getBasicUsers(Arrays.asList(userId), null, null);
        if (CollectionUtil.isEmpty(basicUsers)) {
            throw new IllegalArgumentException("用户的id错误");
        }
        UserDto userDto = basicUsers.get(userId);
        // 2 手机验证码
        validatePhoneCode(userDto.getMobile(),cashSellParam.getValidateCode()) ;
        // 3 支付密码
        checkUserPayPassword(userDto.getPaypassword(), cashSellParam.getPayPassword());
        // 4 远程调用查询用户的银行卡
        UserBankDto userBankInfo = userBankServiceFeign.getUserBankInfo(userId);
        if (userBankInfo == null) {
            throw new IllegalArgumentException("该用户暂未绑定银行卡信息");
        }
        String remark = RandomUtil.randomNumbers(6);
        // 5 通过数量得到本次交易的金额
        BigDecimal amount = getCashWithdrawalsAmount(cashSellParam.getNum());
        // 6 计算本次的手续费
        BigDecimal fee = getCashWithdrawalsFee(amount);
        // 7 查询用户的账号ID
        Account account = accountService.findByUserAndCoin(userId, "GCN");
        // 7 订单的创建
        CashWithdrawals cashWithdrawals = new CashWithdrawals();
        cashWithdrawals.setUserId(userId);
        cashWithdrawals.setAccountId(account.getId());
        cashWithdrawals.setCoinId(cashSellParam.getCoinId());
        cashWithdrawals.setStatus(0);
        cashWithdrawals.setStep(1);
        cashWithdrawals.setNum(cashSellParam.getNum());
        cashWithdrawals.setMum(amount.subtract(fee)); // 实际金额 = amount-fee
        cashWithdrawals.setFee(fee);
        cashWithdrawals.setBank(userBankInfo.getBank());
        cashWithdrawals.setBankCard(userBankInfo.getBankCard());
        cashWithdrawals.setBankAddr(userBankInfo.getBankAddr());
        cashWithdrawals.setBankProv(userBankInfo.getBankProv());
        cashWithdrawals.setBankCity(userBankInfo.getBankCity());
        cashWithdrawals.setTruename(userBankInfo.getRealName());
        cashWithdrawals.setRemark(remark);
        boolean save = save(cashWithdrawals);
        if (save) { //
            // 扣减总资产--account-->accountDetail
            accountService.lockUserAmount(userId, cashWithdrawals.getCoinId(), cashWithdrawals.getMum(), "withdrawals_out", cashWithdrawals.getId(), cashWithdrawals.getFee());
        }
        return save;
    }

    /**
     * 计算本次的手续费
     *
     * @param amount
     * @return
     */
    private BigDecimal getCashWithdrawalsFee(BigDecimal amount) {
        // 1 通过总金额* 费率 = 手续费
        // 2 若金额较小---->最小的提现的手续费

        // 最小的提现费用
        Config withdrawMinPoundage = configService.getConfigByCode("WITHDRAW_MIN_POUNDAGE");
        BigDecimal withdrawMinPoundageFee = new BigDecimal(withdrawMinPoundage.getValue());

        // 提现的费率
        Config withdrawPoundageRate = configService.getConfigByCode("WITHDRAW_POUNDAGE_RATE");


        // 通过费率计算的手续费
        BigDecimal poundageFee = amount.multiply(new BigDecimal(withdrawPoundageRate.getValue())).setScale(2, RoundingMode.HALF_UP);

        //min 取2 个的最小值
        return poundageFee.min(withdrawMinPoundageFee).equals(poundageFee) ? withdrawMinPoundageFee : poundageFee;
    }

    /**
     * 通过数量计算金额
     *
     * @param num
     * @return
     */
    private BigDecimal getCashWithdrawalsAmount(BigDecimal num) {
        //
        Config rateConfig = configService.getConfigByCode("USDT2CNY");
        return num.multiply(new BigDecimal(rateConfig.getValue())).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 支付密码的校验
     *
     * @param payDBPassword
     * @param payPassword
     */
    private void checkUserPayPassword(String payDBPassword, String payPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(payPassword, payDBPassword);
        if (!matches) {
            throw new IllegalArgumentException("支付密码错误");
        }
    }

    /**
     * 校验用户的手机验证码
     *
     * @param mobile
     * @param validateCode
     */
    private void validatePhoneCode(String mobile, String validateCode) {

    }

    /**
     * 1 手机验证码
     * 2 支付密码
     * 3 提现相关的验证
     *
     * @param cashSellParam
     */
    private void checkCashSellParam(CashSellParam cashSellParam) {
        // 1 提现状态
        Config cashWithdrawalsStatus = configService.getConfigByCode("WITHDRAW_STATUS");
        if (Integer.valueOf(cashWithdrawalsStatus.getValue()) != 1) {
            throw new IllegalArgumentException("提现暂未开启");
        }
        // 2 提现的金额
        @NotNull BigDecimal cashSellParamNum = cashSellParam.getNum();
        // 2.1 最小的提现额度100
        Config cashWithdrawalsConfigMin = configService.getConfigByCode("WITHDRAW_MIN_AMOUNT");
        //101
        if (cashSellParamNum.compareTo(new BigDecimal(cashWithdrawalsConfigMin.getValue())) < 0) {
            throw new IllegalArgumentException("检查提现的金额");
        }
        // 2.1 最小的提现额度200
        // 201
        Config cashWithdrawalsConfigMax = configService.getConfigByCode("WITHDRAW_MAX_AMOUNT");
        if (cashSellParamNum.compareTo(new BigDecimal(cashWithdrawalsConfigMax.getValue())) >= 0) {
            throw new IllegalArgumentException("检查提现的金额");
        }
    }
}




