package com.jamie.im.admin.controller;

import com.jamie.im.admin.domain.Permission;
import com.jamie.im.admin.service.PermissionService;
import com.jamie.im.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 权限控制器
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@RestController
@RequestMapping("permission")
public class PermissionController extends BaseController<Permission, PermissionService> {

}
