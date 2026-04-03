package com.fifteen.service;

import com.fifteen.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【sys_menu(系统菜单)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据用户ID查询菜单
     *
     * @param userId
     * @return
     */
    List<SysMenu> getMenusByUserId(Long userId);
}
