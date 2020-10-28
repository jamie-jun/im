package com.jamie.im.admin.service;

import com.jamie.im.admin.dto.PermissionParam;
import com.jamie.im.common.base.BaseService;
import com.jamie.im.admin.domain.Permission;

import java.util.List;

/**
* <p>
* 后台用户权限表 服务类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface PermissionService extends BaseService<Permission> {

    List<PermissionParam> findPermissionByUserId(Long userId);

}
