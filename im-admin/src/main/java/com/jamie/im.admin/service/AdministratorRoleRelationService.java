package com.jamie.im.admin.service;

import com.jamie.im.admin.domain.AdministratorRoleRelation;
import com.jamie.im.common.base.BaseService;
import java.util.List;

/**
* <p>
* 用户角色表 服务类
* </p>
*
* @author jamie
* @since 2020-10-10
*/
public interface AdministratorRoleRelationService extends BaseService<AdministratorRoleRelation> {

    /**
     * 根据用户id查询用户关系
     * @param adminId
     * @return
     */
    List<AdministratorRoleRelation>  selectByAdminId(Long adminId);

    /**
     * 根据用户id删除用户关系
     * @param adminId
     * @return
     */
    int delByAdminId(Long adminId);

    /**
     *批量插入
     */
    int inserBatch(List<AdministratorRoleRelation> userRoles);
}
