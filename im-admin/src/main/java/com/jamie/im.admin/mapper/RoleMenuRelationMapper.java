package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.domain.RoleMenuRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
* <p>
* 后台角色菜单关系表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-12
*/
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation> {

    @Delete("DELETE FROM upms_role_menu_relation as urmr where urmr.role_id = #{roleId}")
    int delByRoleId(Long roleId);

    @Select("SELECT um.* FROM upms_role_menu_relation as urmr  LEFT JOIN upms_menu as um ON urmr.menu_id = um.id WHERE urmr.role_id = #{roleId} ")
    List<Menu> selectByRoleId(Long roleId);

}
