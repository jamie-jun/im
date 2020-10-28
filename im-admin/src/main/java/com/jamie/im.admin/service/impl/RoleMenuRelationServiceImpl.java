package com.jamie.im.admin.service.impl;


import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.domain.RoleMenuRelation;
import com.jamie.im.admin.mapper.RoleMenuRelationMapper;
import com.jamie.im.admin.service.RoleMenuRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* 后台角色菜单关系表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-12
*/
@Service
public class RoleMenuRelationServiceImpl extends BaseServiceImpl<RoleMenuRelationMapper, RoleMenuRelation> implements RoleMenuRelationService {

    @Autowired
    private RoleMenuRelationMapper roleMenuMapper;

    @Override
    public int delByRoleId(Long roleId) {
        return roleMenuMapper.delByRoleId(roleId);
    }

    @Override
    public int insertBatch(List<RoleMenuRelation> roleMenus) {
        roleMenus.stream().forEach(roleMenu -> roleMenuMapper.insert(roleMenu));
        return roleMenus.size();
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }

}
