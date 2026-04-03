package com.fifteen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.SysPrivilege;
import com.fifteen.service.SysPrivilegeService;
import com.fifteen.mapper.SysPrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author msc
 * @description 针对表【sys_privilege(权限配置)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class SysPrivilegeServiceImpl extends ServiceImpl<SysPrivilegeMapper, SysPrivilege>
        implements SysPrivilegeService {

    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    @Override
    public List<SysPrivilege> getAllSysPrivileges(Long menuId, Long roleId) {
        // 获取所有的权限
        List<SysPrivilege> sysPrivileges = list(new LambdaQueryWrapper<SysPrivilege>().eq(SysPrivilege::getMenuId, menuId));
        if (CollectionUtil.isEmpty(sysPrivileges)) {
            return Collections.emptyList();
        }
        // 当前传递的角色使用包含该权限的信息也要放进去
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            Set<Long> currentRoleSysPrivileges = sysPrivilegeMapper.getPrivilegesByRoleId(roleId);
            if (currentRoleSysPrivileges.contains(sysPrivilege.getId())) {
                sysPrivilege.setOwn(1);
            }
        }
        return sysPrivileges;
    }
}




