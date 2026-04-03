package com.fifteen.service;

import com.fifteen.domain.SysPrivilege;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author msc
 * @description 针对表【sys_privilege(权限配置)】的数据库操作Service
 * @createDate 2026-03-12 17:29:37
 */
public interface SysPrivilegeService extends IService<SysPrivilege> {

    /**
     * 获取角色权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    List<SysPrivilege> getAllSysPrivileges(Long menuId, Long roleId);
}
