package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.SysRole;
import com.fifteen.service.SysRoleService;
import com.fifteen.mapper.SysRoleMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author msc
 * @description 针对表【sys_role(角色)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public boolean isSuperAdmin(Long userId) {
        //当用户的角色code为：ROLE_ADMIN 的时候，则认为用户是超级管理员
        //用户的id->角色id->角色code
        String roleCode = sysRoleMapper.getUserRoleCode(userId);
        if (StringUtils.isNotBlank(roleCode) && roleCode.equals("ROLE_ADMIN")) {
            return true;
        }
        return false;
    }

    @Override
    public Page<SysRole> findByPage(Page<SysRole> page, String name) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<SysRole>()
                .like(StringUtils.isNotBlank(name), SysRole::getName, name)
                .orderByDesc(SysRole::getLastUpdateTime);
        return page(page, queryWrapper);
    }
}




