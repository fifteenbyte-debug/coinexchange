package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【sys_role(角色)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 判断是否是超级管理员
     * @param userId
     * @return
     */
    boolean isSuperAdmin(Long userId);

    /**
     * 使用角色名称模糊分页查询角色
     * @param page
     * @param name
     * @return
     */
    Page<SysRole> findByPage(Page<SysRole> page, String name);
}
