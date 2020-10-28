package com.jamie.im.admin.service;

import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.domain.RoleMenuRelation;
import com.jamie.im.common.base.BaseService;

import java.util.List;

/**
* <p>
* 后台角色菜单关系表 服务类
* </p>
*
* @author jamie
* @since 2020-10-12
*/
public interface RoleMenuRelationService extends BaseService<RoleMenuRelation> {

    /**
     * 根据角色删除
     *
     * @param roleId
     * @return
     */
    int delByRoleId(Long roleId);

    /**
     * 批量插入
     *
     * @param roleMenus
     * @return
     */
    int insertBatch(List<RoleMenuRelation> roleMenus);

    /**
     * 根据角色查询菜单
     *
     * @param roleId
     * @return
     */
    List<Menu> listMenu(Long roleId);

}