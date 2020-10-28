package com.jamie.im.admin.service;


import com.jamie.im.admin.domain.RoleResourceRelation;
import com.jamie.im.common.base.BaseService;

/**
* <p>
* 后台角色资源分类资源关系表 服务类
* </p>
*
* @author jamie
* @since 2020-10-15
*/
public interface RoleResourceRelationService extends BaseService<RoleResourceRelation> {

    boolean delByRoleId(Long roleId);

}
