package com.fifteen.mapper;

import com.fifteen.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【sys_role(角色)】的数据库操作Mapper
* @createDate 2026-03-12 17:29:37
* @Entity com.fifteen.domain.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 获取用户的角色编码
     * @param userId
     * @return
     */
    @Select("select code from sys_role where id in (select role_id from sys_user_role where user_id = #{userId})")
    String getUserRoleCode(Long userId);
}




