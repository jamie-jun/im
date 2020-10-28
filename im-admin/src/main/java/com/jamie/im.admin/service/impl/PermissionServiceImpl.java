package com.jamie.im.admin.service.impl;

import com.jamie.im.admin.dto.PermissionParam;
import com.jamie.im.common.base.BaseServiceImpl;
import com.jamie.im.admin.domain.Permission;
import com.jamie.im.admin.mapper.PermissionMapper;
import com.jamie.im.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* 后台用户权限表 服务实现类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionParam> findPermissionByUserId(Long userId) {
        return permissionMapper.findPermissionByUserId(userId);
    }
}
