package com.jamie.im.admin.service;

import com.jamie.im.admin.domain.RoleResourceCategoryRelation;
import com.jamie.im.common.base.BaseService;

import java.util.List;

/**
* <p>
* 后台角色资源关系表 服务类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface RoleResourceCategoryRelationService extends BaseService<RoleResourceCategoryRelation> {

    /**
     * 根据角色id删除角色对应关系
     * @return
     */
    int delByRoleId(Long roleId);

    /**
     * 根据角色id查询角色对应关系
     * @return
     */
    List<RoleResourceCategoryRelation> findByRoleId(Long roleId);

}
