package com.jamie.im.admin.service;

import com.jamie.im.admin.domain.ResourceCategory;
import com.jamie.im.admin.dto.ResourceCategoryDto;
import com.jamie.im.common.base.BaseService;

import java.util.List;

/**
* <p>
* 资源分类表 服务类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface ResourceCategoryService extends BaseService<ResourceCategory> {

    List<ResourceCategoryDto> listAll();

    ResourceCategoryDto getResourceCategory(Long id);
}
