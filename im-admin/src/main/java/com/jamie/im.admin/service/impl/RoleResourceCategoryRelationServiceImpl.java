package com.jamie.im.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jamie.im.admin.domain.RoleResourceCategoryRelation;
import com.jamie.im.admin.mapper.RoleResourceCategoryRelationMapper;
import com.jamie.im.admin.service.RoleResourceCategoryRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* 后台角色资源关系表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
@Service
public class RoleResourceCategoryRelationServiceImpl extends BaseServiceImpl<RoleResourceCategoryRelationMapper, RoleResourceCategoryRelation> implements RoleResourceCategoryRelationService {

    @Override
    public int delByRoleId(Long roleId) {
        return this.baseMapper.delByRoleId(roleId);
    }

    @Override
    public List<RoleResourceCategoryRelation> findByRoleId(Long roleId) {
        LambdaQueryWrapper<RoleResourceCategoryRelation> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(RoleResourceCategoryRelation::getRoleId,roleId);
        return super.list(wrapper);
    }
}
