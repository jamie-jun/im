package com.jamie.im.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.*;
import com.jamie.im.admin.dto.ResourceDto;
import com.jamie.im.admin.mapper.ResourceMapper;
import com.jamie.im.admin.service.*;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* <p>
* 后台资源表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private RoleResourceCategoryRelationService roleResourceCategoryService;

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    @Autowired
    private ResourceCategoryResourceRelationService resourceCategoryResourceRelationService;

    @Override
    public List<Resource> listAll() {
        return super.list();
    }

    @Override
    public List<Resource> listByRoleId(Long id) {
        return super.baseMapper.listByRoleId(id);
    }

    @Override
    public int delByRoleId(Long roleId) {
        roleResourceCategoryService.delByRoleId(roleId);
        roleResourceRelationService.delByRoleId(roleId);
        return 0;
    }

    @Override
    public int saveByRoleId(Long roleId,Map<String,List<String>> relationMap) {
        ArrayList<RoleResourceCategoryRelation> roleResourceCategoryRelations = new ArrayList<>();
        relationMap.forEach((k,v) ->{
            //分类
            roleResourceCategoryRelations.add(new RoleResourceCategoryRelation()
                    .setRoleId(roleId).setResourceCategoryId(Long.parseLong(k)));
            //资源
            ArrayList<RoleResourceRelation> roleResourceCategoryResourceRelations = new ArrayList<>();
            v.stream().forEach(rid ->
              roleResourceCategoryResourceRelations.add(new RoleResourceRelation()
                      .setRoleId(roleId)
                      .setResourceId(Long.parseLong(rid))));
            roleResourceRelationService.saveBatch(roleResourceCategoryResourceRelations);
        });
        roleResourceCategoryService.saveBatch(roleResourceCategoryRelations);
        return roleResourceCategoryRelations.size();
    }

    @Override
    public List<RoleResourceRelation> fetchResourceAllRelation() {
        return roleResourceRelationService.list();
    }

    @Override
    public List<ResourceCategoryResourceRelation> fetchResourceCateRelation() {
        return resourceCategoryResourceRelationService.list();
    }

    @Override
    public Page<ResourceDto> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        Page<Resource> page = new Page<>(pageNum, pageSize);
//        LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
//        wrapper
//                .like(StringUtils.isNotBlank(nameKeyword),Resource::getName,nameKeyword)
//                .like(StringUtils.isNotBlank(urlKeyword),Resource::getUrl,urlKeyword);
        return super.baseMapper.listInfo(page,categoryId,nameKeyword,urlKeyword);
    }

    @Override
    public int add(Long categoryId, Resource resource) {
        super.save(resource);
        resourceCategoryResourceRelationService.save(new ResourceCategoryResourceRelation()
                .setResourceCategoryId(categoryId)
                .setResourceId(resource.getId()));
        return 0;
    }

    @Override
    public int updateResource(Long categoryId, Resource resource) {
        super.update(resource);
        ResourceCategoryResourceRelation relation = resourceCategoryResourceRelationService.get(categoryId, resource.getId());
        resourceCategoryResourceRelationService.update(relation);
        return 0;
    }

    @Override
    public List<ResourceCategoryResourceRelation> getRelation() {
        return resourceCategoryResourceRelationService.list();
    }

}
