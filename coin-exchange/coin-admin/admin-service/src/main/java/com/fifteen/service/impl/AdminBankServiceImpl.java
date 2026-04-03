package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.AdminBank;
import com.fifteen.dto.AdminBankDto;
import com.fifteen.mappers.AdminBankDtoMappers;
import com.fifteen.service.AdminBankService;
import com.fifteen.mapper.AdminBankMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author msc
 * @description 针对表【admin_bank(人民币充值卡号管理)】的数据库操作Service实现
 * @createDate 2026-03-17 16:33:07
 */
@Service
public class AdminBankServiceImpl extends ServiceImpl<AdminBankMapper, AdminBank>
        implements AdminBankService {

    @Override
    public Page<AdminBank> findByPage(Page<AdminBank> page, String bankCard) {
        return page(page, new LambdaQueryWrapper<AdminBank>()
                .like(StringUtils.isNotBlank(bankCard), AdminBank::getBankCard, bankCard)
        );
    }

    @Override
    public List<AdminBankDto> getAllAdminBanks() {
        List<AdminBank> adminBanks = list(new LambdaQueryWrapper<AdminBank>().eq(AdminBank::getStatus, 1));
        if (CollectionUtil.isEmpty(adminBanks)) {
            return Collections.emptyList();
        }
        List<AdminBankDto> adminBankDtos = AdminBankDtoMappers.INSTANCE.toConvertDto(adminBanks);
        return adminBankDtos;
    }
}




