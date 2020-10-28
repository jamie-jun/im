package com.jamie.im.admin.service.impl;

import com.jamie.im.admin.domain.ResourceCategoryResourceRelation;
import com.jamie.im.admin.mapper.ResourceCategoryResourceRelationMapper;
import com.jamie.im.admin.service.ResourceCategoryResourceRelationService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
* <p>
* 资源分类和资源关系表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-17
*/
@Service
public class ResourceCategoryResourceRelationServiceImpl extends BaseServiceImpl<ResourceCategoryResourceRelationMapper, ResourceCategoryResourceRelation> implements ResourceCategoryResourceRelationService {

    @Override
    public ResourceCategoryResourceRelation get(Long categoryId, Long resourceId) {
        return this.baseMapper.get(categoryId,resourceId);
    }
}
