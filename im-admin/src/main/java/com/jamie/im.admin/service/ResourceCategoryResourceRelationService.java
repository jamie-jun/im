package com.jamie.im.admin.service;


import com.jamie.im.admin.domain.ResourceCategoryResourceRelation;
import com.jamie.im.common.base.BaseService;

/**
* <p>
* 资源分类和资源关系表 服务类
* </p>
*
* @author jamie
* @since 2020-10-17
*/
public interface ResourceCategoryResourceRelationService extends BaseService<ResourceCategoryResourceRelation> {

    ResourceCategoryResourceRelation get(Long categoryId,Long resourceId);

}
