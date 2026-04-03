package com.fifteen.service;

import com.fifteen.domain.SysMenu;
import com.fifteen.domain.SysRolePrivilege;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.model.RolePrivilegesParam;

import java.util.List;

/**
* @author msc
* @description 针对表【sys_role_privilege(角色权限配置)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface SysRolePrivilegeService extends IService<SysRolePrivilege> {

    /**
     * 根据角色id查询菜单和权限
     * @param roleId
     * @return
     */
    List<SysMenu> findSysMenuAndPrivileges(Long roleId);

    /**
     * 给角色授权权限
     * @param rolePrivilegesParam
     * @return
     */
    boolean grantPrivileges(RolePrivilegesParam rolePrivilegesParam);
}
