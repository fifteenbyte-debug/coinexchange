package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CashWithdrawals;
import com.fifteen.domain.CoinWithdraw;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.service.CoinWithdrawService;
import com.fifteen.mapper.CoinWithdrawMapper;
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
* @description 针对表【coin_withdraw(数字货币提现记录)】的数据库操作Service实现
* @createDate 2026-03-24 10:59:51
*/
@Service
public class CoinWithdrawServiceImpl extends ServiceImpl<CoinWithdrawMapper, CoinWithdraw>
    implements CoinWithdrawService{

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public Page<CoinWithdraw> findByPage(Page<CoinWithdraw> page, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime) {
        Map<Long, UserDto> basicUsers = null;
        LambdaQueryWrapper<CoinWithdraw> queryWrapper = new LambdaQueryWrapper<CoinWithdraw>();
        if (userId != null || !StringUtils.isEmpty(userName) || !StringUtils.isEmpty(mobile)) {
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtil.isEmpty(basicUsers)) {
                return page;
            }
            queryWrapper.in(CoinWithdraw::getUserId, basicUsers.keySet());
        }
        queryWrapper.eq(status != null, CoinWithdraw::getStatus, status);
        queryWrapper.between(StringUtils.isNotEmpty(numMin) || StringUtils.isNotEmpty(numMax), CoinWithdraw::getNum, new BigDecimal(StringUtils.isEmpty(numMin) ? "0" : numMin), new BigDecimal(StringUtils.isEmpty(numMax) ? "0" : numMax));
        queryWrapper.between(StringUtils.isNotEmpty(startTime) || StringUtils.isNotEmpty(endTime), CoinWithdraw::getCreated, startTime, endTime + " 23:59:59");
        Page<CoinWithdraw> pageDate = this.page(page, queryWrapper);
        List<CoinWithdraw> records = pageDate.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            List<Long> userIds = records.stream().map(CoinWithdraw::getUserId).collect(Collectors.toList());
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

}




