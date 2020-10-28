package com.jamie.im.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jamie.im.admin.domain.AdministratorRoleRelation;
import com.jamie.im.admin.mapper.AdministratorRoleRelationMapper;
import com.jamie.im.admin.service.AdministratorRoleRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* 用户角色表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-10
*/
@Service
public class AdministratorRoleRelationServiceImpl extends BaseServiceImpl<AdministratorRoleRelationMapper, AdministratorRoleRelation> implements AdministratorRoleRelationService {

    @Autowired
    private AdministratorRoleRelationMapper userRoleMapper;

    @Override
    public List<AdministratorRoleRelation> selectByAdminId(Long adminId) {
        LambdaQueryWrapper<AdministratorRoleRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdministratorRoleRelation::getUserId,adminId);
        return userRoleMapper.selectList(wrapper);
    }

    @Override
    public int delByAdminId(Long adminId) {
        LambdaQueryWrapper<AdministratorRoleRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdministratorRoleRelation::getUserId,adminId);
        return userRoleMapper.delete(wrapper);
    }

    @Override
    public int inserBatch(List<AdministratorRoleRelation> userRoles) {
        userRoles.stream().forEach(userRole -> userRoleMapper.insert(userRole));
        return 1;
    }


}
