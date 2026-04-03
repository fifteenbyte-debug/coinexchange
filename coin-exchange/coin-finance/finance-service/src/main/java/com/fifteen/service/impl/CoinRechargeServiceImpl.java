package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CashRecharge;
import com.fifteen.domain.CoinRecharge;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.service.CoinRechargeService;
import com.fifteen.mapper.CoinRechargeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【coin_recharge(数字货币充值记录)】的数据库操作Service实现
 * @createDate 2026-03-24 10:59:51
 */
@Service
public class CoinRechargeServiceImpl extends ServiceImpl<CoinRechargeMapper, CoinRecharge>
        implements CoinRechargeService {

    @Autowired
    private UserServiceFeign userServiceFeign;


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
    public Page<CoinRecharge> findByPage(Page<CoinRecharge> page, Long coinId, Long userId, String userName,
                                         String mobile, Byte status, String numMin, String numMax, String startTime,
                                         String endTime) {
        LambdaQueryWrapper<CoinRecharge> coinRechargeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 1 使用用户相关的字段进行查询
        Map<Long, UserDto> basicUsers = null;
        if (userId != null || !StringUtils.isEmpty(userName) || !StringUtils.isEmpty(mobile)) {
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtil.isEmpty(basicUsers)) { // 没有用户
                return page;
            }
            coinRechargeLambdaQueryWrapper.in(CoinRecharge::getUserId, basicUsers.keySet()); // 使用用户的信息做条件
        }
        // 添加其他的条件
        coinRechargeLambdaQueryWrapper.eq(coinId != null, CoinRecharge::getCoinId, coinId)
                .eq(status != null, CoinRecharge::getStatus, status)
                .between(
                        !(StringUtils.isEmpty(numMin) || StringUtils.isEmpty(numMax)),
                        CoinRecharge::getAmount,
                        new BigDecimal(numMin == null ? "0" : numMin), new BigDecimal(numMax == null ? "0" : numMax)
                )
                .between(
                        !(StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)),
                        CoinRecharge::getCreated,
                        startTime, endTime + "23:23:59"
                );
        // 查询
        Page<CoinRecharge> pageData = page(page, coinRechargeLambdaQueryWrapper);
        // 获取查询的数据
        List<CoinRecharge> records = pageData.getRecords();
        if (!CollectionUtil.isEmpty(records)) {
            if (basicUsers == null) { // 说明前面没有使用用户的信息查询用户
                List<Long> userIds = records.stream().map(coinRecharge -> coinRecharge.getUserId()).collect(Collectors.toList());
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

}




