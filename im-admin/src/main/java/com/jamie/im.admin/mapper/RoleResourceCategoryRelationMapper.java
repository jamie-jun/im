package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamie.im.admin.domain.RoleResourceCategoryRelation;
import org.apache.ibatis.annotations.Delete;

/**
* <p>
* 后台角色资源关系表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface RoleResourceCategoryRelationMapper extends BaseMapper<RoleResourceCategoryRelation> {

    @Delete("delete from upms_role_resource_category_relation as urrcr where urrcr.role_id = #{roleId}")
    int delByRoleId(Long roleId);
}
