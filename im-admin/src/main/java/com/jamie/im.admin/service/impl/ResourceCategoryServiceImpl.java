package com.jamie.im.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jamie.im.admin.domain.ResourceCategory;
import com.jamie.im.admin.dto.ResourceCategoryDto;
import com.jamie.im.admin.mapper.ResourceCategoryMapper;
import com.jamie.im.admin.service.ResourceCategoryService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* 资源分类表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
@Service
public class ResourceCategoryServiceImpl extends BaseServiceImpl<ResourceCategoryMapper, ResourceCategory> implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategoryDto> listAll() {
        return resourceCategoryMapper.findAll();
    }

    @Override
    public ResourceCategoryDto getResourceCategory(Long id) {
        return resourceCategoryMapper.get(id);
    }
}
