package com.fifteen.mapper;

import com.fifteen.domain.SysPrivilege;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
* @author msc
* @description 针对表【sys_privilege(权限配置)】的数据库操作Mapper
* @createDate 2026-03-12 17:29:37
* @Entity com.fifteen.domain.SysPrivilege
*/
public interface SysPrivilegeMapper extends BaseMapper<SysPrivilege> {

    /**
     * 根据角色id获取权限id
     * @param roleId
     * @return
     */
    @Select("select privilege_id from sys_role_privilege where role_id = #{roleId}")
    Set<Long> getPrivilegesByRoleId(Long roleId);
}




