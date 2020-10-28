package com.jamie.im.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.*;
import com.jamie.im.admin.service.ResourceService;
import com.jamie.im.admin.service.RoleMenuRelationService;
import com.jamie.im.admin.service.AdministratorRoleRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import com.jamie.im.admin.mapper.RoleMapper;
import com.jamie.im.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* <p>
* 后台用户角色表 服务实现类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdministratorRoleRelationService userRoleService;

    @Autowired
    private RoleMenuRelationService roleMenuService;

    @Autowired
    private ResourceService resourceService;

    @Override
    public List<com.jamie.im.admin.dto.Role> getRoleList(Long adminId) {
        return roleMapper.getRoleList(adminId);
    }

    @Override
    public Page<com.jamie.im.admin.dto.Role> roles(String keyword, Integer pageSize, Integer pageNum) {
        Page<com.jamie.im.admin.dto.Role> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<com.jamie.im.admin.dto.Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(keyword), com.jamie.im.admin.dto.Role::getName,keyword);
        return roleMapper.selectRoles(page,wrapper);
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //删除原来关系
        userRoleService.delByAdminId(adminId);
        //建立新的关系
        if(roleIds.size()<=0){
            return 0;
        }
        List<AdministratorRoleRelation> userRoles = new ArrayList<>();
        roleIds.stream().forEach(id ->
                userRoles.add(new AdministratorRoleRelation().setUserId(adminId).setRoleId(id))
        );
        userRoleService.inserBatch(userRoles);
        return count;
    }

    @Override
    public int delRole(Long adminId) {
        return userRoleService.delByAdminId(adminId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        roleMenuService.delByRoleId(roleId);
        //批量插入新关系
        ArrayList<RoleMenuRelation> upmsRoleMenus = new ArrayList<>();
        menuIds.stream().forEach(id ->
            upmsRoleMenus.add(new RoleMenuRelation()
                    .setRoleId(roleId)
                    .setMenuId(id)));
        roleMenuService.insertBatch(upmsRoleMenus);
        return menuIds.size();
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        return roleMenuService.listMenu(roleId);
    }

    @Override
    public List<com.jamie.im.admin.dto.Role> getAll() {
        ArrayList<com.jamie.im.admin.dto.Role> roles = new ArrayList<>();
        roleMapper.selectList(new LambdaQueryWrapper<>()).stream()
                .forEach(upmsRole -> {
                    com.jamie.im.admin.dto.Role role = new com.jamie.im.admin.dto.Role();
                    BeanUtil.copyProperties(upmsRole,role);
                    roles.add(role);
                });
        return roles;
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        return resourceService.listByRoleId(roleId);
    }

    @Override
    public int allocResource(Long roleId, Map<String,List<String>> relationMap) {
        //先删除原有关系
        resourceService.delByRoleId(roleId);
        //批量插入新关系
        resourceService.saveByRoleId(roleId,relationMap);
        return relationMap.size();
    }

}
