package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* <p>
* 后台用户角色表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT ur.* FROM upms_administrator_role_relation as uarr LEFT JOIN upms_role as ur on uarr.role_id = ur.id WHERE uarr.user_id = #{adminId}")
    List<com.jamie.im.admin.dto.Role> getRoleList(@Param(value = "adminId") Long adminId);

    @Select("SELECT ur.* FROM upms_role  as ur ${ew.customSqlSegment}")
    Page<com.jamie.im.admin.dto.Role> selectRoles(Page<com.jamie.im.admin.dto.Role> page, @Param(Constants.WRAPPER) Wrapper<com.jamie.im.admin.dto.Role> wrapper);
}
