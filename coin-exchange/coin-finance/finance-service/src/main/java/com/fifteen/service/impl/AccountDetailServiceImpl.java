package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.AccountDetail;
import com.fifteen.domain.CoinWithdraw;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.service.AccountDetailService;
import com.fifteen.mapper.AccountDetailMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【account_detail(资金账户流水)】的数据库操作Service实现
 * @createDate 2026-03-24 10:59:51
 */
@Service
public class AccountDetailServiceImpl extends ServiceImpl<AccountDetailMapper, AccountDetail>
        implements AccountDetailService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public Page<AccountDetail> findByPage(Page<AccountDetail> page, Long accountId, Long coinId, Long userId, String userName, String mobile, String amountStart, String amountEnd, String startTime, String endTime) {
        LambdaQueryWrapper<AccountDetail> queryWrapper = new LambdaQueryWrapper<>();
        Map<Long, UserDto> basicUsers=null;
        if (userId != null || !StringUtils.isEmpty(userName) || !StringUtils.isEmpty(mobile)) {
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtil.isEmpty(basicUsers)) {
                return page;
            }
            Set<Long> userIds = basicUsers.keySet();
            queryWrapper.in(AccountDetail::getUserId, userIds);
        }
        queryWrapper.eq(accountId != null, AccountDetail::getAccountId, accountId)
                .eq(coinId != null, AccountDetail::getCoinId, coinId)
                .between(StringUtils.isNotEmpty(amountStart) || StringUtils.isNotEmpty(amountEnd), AccountDetail::getAmount,
                        new BigDecimal(StringUtils.isEmpty(amountStart) ? "0" : amountStart), new BigDecimal(StringUtils.isEmpty(amountEnd) ? "0" : amountEnd))
                .between(StringUtils.isNotEmpty(startTime) || StringUtils.isNotEmpty(endTime), AccountDetail::getCreated, startTime, StringUtils.isEmpty(endTime) ? null : endTime + " 23:59:59");
        Page<AccountDetail> accountDetailPage = page(page, queryWrapper);
        List<AccountDetail> records = accountDetailPage.getRecords();
        if(CollectionUtil.isNotEmpty(records)){
            List<Long> userIds = records.stream().map(AccountDetail::getUserId).collect(Collectors.toList());
            if(basicUsers == null){
                basicUsers = userServiceFeign.getBasicUsers(userIds, null, null);
            }
            Map<Long, UserDto> finalBasicUsers = basicUsers;
            records.forEach(record -> {
                UserDto userDto = finalBasicUsers.get(record.getUserId());
                if(userDto != null){
                    record.setUsername(userDto.getUsername());
                    record.setRealName(userDto.getRealName());
                }
            });
        }
        return accountDetailPage;
    }
}




