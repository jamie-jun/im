package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamie.im.admin.domain.ResourceCategory;
import com.jamie.im.admin.dto.ResourceCategoryDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* <p>
* 资源分类表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface ResourceCategoryMapper extends BaseMapper<ResourceCategory> {

    @Select("SELECT rc.* FROM upms_resource_category AS rc")
    List<ResourceCategoryDto> findAll();

    @Select("SELECT  rc.* FROM upms_resource_category AS rc WHERE  rc.id")
    ResourceCategoryDto get(Long id);

}
