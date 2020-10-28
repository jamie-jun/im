package com.jamie.im.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jamie.im.admin.domain.RoleResourceRelation;
import com.jamie.im.admin.mapper.RoleResourceRelationMapper;
import com.jamie.im.admin.service.RoleResourceRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
* <p>
* 后台角色资源分类资源关系表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-15
*/
@Service
public class RoleResourceRelationServiceImpl extends BaseServiceImpl<RoleResourceRelationMapper, RoleResourceRelation> implements RoleResourceRelationService {

    @Override
    public boolean delByRoleId(Long roleId) {
        LambdaQueryWrapper<RoleResourceRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleResourceRelation::getRoleId,roleId);
        return super.remove(wrapper);
    }
}
