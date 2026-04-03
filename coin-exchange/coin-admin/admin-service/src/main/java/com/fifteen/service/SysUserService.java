package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【sys_user(平台用户)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询员工
     * @param page
     * @param mobile
     * @param fullname
     * @return
     */
    Page<SysUser> findByPage(Page<SysUser> page, String mobile, String fullname);

    boolean addUser(SysUser sysUser);
}
