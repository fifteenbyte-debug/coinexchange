package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.SysUser;
import com.fifteen.domain.SysUserRole;
import com.fifteen.service.SysUserRoleService;
import com.fifteen.service.SysUserService;
import com.fifteen.mapper.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【sys_user(平台用户)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public Page<SysUser> findByPage(Page<SysUser> page, String mobile, String fullname) {
        Page<SysUser> pageData = page(page, new LambdaQueryWrapper<SysUser>()
                .like(StringUtils.isNotBlank(mobile), SysUser::getMobile, mobile)
                .like(StringUtils.isNotBlank(fullname), SysUser::getFullname, fullname)
        );
        List<SysUser> records = pageData.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            for (SysUser record : records) {
                List<SysUserRole> userRoles = sysUserRoleService.list(
                        new LambdaQueryWrapper<SysUserRole>()
                                .eq(SysUserRole::getUserId, record.getId())
                );
                if (CollectionUtil.isNotEmpty(userRoles)) {
                    record.setRole_strings(userRoles.stream().map(SysUserRole::getRoleId).map(String::valueOf).collect(Collectors.joining(",")));
                }
            }

        }
        return pageData;
    }

    @Override
    @Transactional
    public boolean addUser(SysUser sysUser) {
        String password = sysUser.getPassword();
        String roleStrings = sysUser.getRole_strings();
        String encode = new BCryptPasswordEncoder().encode(password);
        sysUser.setPassword(encode);
        boolean save = super.save(sysUser);
        if (save) {
            if (StringUtils.isNotBlank(roleStrings)) {
                String[] roleIds = roleStrings.split(",");
                List<SysUserRole> sysUserRoles = new ArrayList<>(roleIds.length);
                for (String roleId : roleIds) {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setRoleId(Long.valueOf(roleId));
                    sysUserRole.setUserId(sysUser.getId());
                    sysUserRoles.add(sysUserRole);
                }
                sysUserRoleService.saveBatch(sysUserRoles);
            }
        }
        return save;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        boolean b = super.removeByIds(idList);
        sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().in(SysUserRole::getUserId, idList));
        return b;
    }
}




