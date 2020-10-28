package com.jamie.im.admin.service.impl;

import com.jamie.im.admin.domain.RolePermissionRelation;
import com.jamie.im.admin.mapper.RolePermissionRelationMapper;
import com.jamie.im.admin.service.RolePermissionRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
* 角色权限表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-10
*/
@Service
public class RolePermissionRelationServiceImpl extends BaseServiceImpl<RolePermissionRelationMapper, RolePermissionRelation> implements RolePermissionRelationService {

    @Autowired
    private RolePermissionRelationMapper rolePermissionMapper;

}
