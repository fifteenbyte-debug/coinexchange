package com.fifteen.mapper;

import com.fifteen.domain.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author msc
 * @description 针对表【sys_menu(系统菜单)】的数据库操作Mapper
 * @createDate 2026-03-12 17:29:37
 * @Entity com.fifteen.domain.SysMenu
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户ID查询菜单
     *
     * @param userId
     * @return
     */
    @Select("select m.* from sys_menu as m left join sys_role_menu as rm on rm.menu_id=m.id" +
            " left join sys_user_role as ur on ur.role_id=rm.role_id" +
            " where ur.user_id= #{userId}")
    List<SysMenu> getMenusByUserId(Long userId);
}




