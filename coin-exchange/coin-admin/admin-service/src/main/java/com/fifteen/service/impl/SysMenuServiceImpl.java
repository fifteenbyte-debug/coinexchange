package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.SysMenu;
import com.fifteen.service.SysMenuService;
import com.fifteen.mapper.SysMenuMapper;
import com.fifteen.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author msc
 * @description 针对表【sys_menu(系统菜单)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getMenusByUserId(Long userId) {
        //1. 如果用户是超级管理员拥有所有的菜单权限
        if (sysRoleService.isSuperAdmin(userId)) {
            return list();
        }
        return sysMenuMapper.getMenusByUserId(userId);
    }
}




