package com.jamie.im.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.dto.AdminAddParam;
import com.jamie.im.admin.dto.AdminCommonParam;
import com.jamie.im.admin.dto.PermissionParam;
import com.jamie.im.common.base.BaseService;
import com.jamie.im.admin.domain.Administrator;
import com.jamie.im.common.dto.UserDto;
import com.jamie.im.common.response.ResponseResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* <p>
* 用户表 服务类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface AdministratorService extends BaseService<Administrator> {

    Administrator getAdminByUsername(String username);


    List<PermissionParam> getRoleList(Long adminId);

    UserDto loadUserByUsername(String username);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    ResponseResult login(String username, String password);

    /**
     * 注册功能
     */
    Administrator register(AdminAddParam umsAdminParam);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<AdminCommonParam> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改用户
     * @param updateParam
     * @return
     */
    Administrator updateUser(AdminCommonParam updateParam);

    /**
     * 删除用户
     */
    @Transactional
    int del(Long adminId);
}
