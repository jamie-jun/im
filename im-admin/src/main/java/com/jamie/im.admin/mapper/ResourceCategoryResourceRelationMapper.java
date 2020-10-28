package com.jamie.im.admin.mapper;

import com.jamie.im.admin.domain.ResourceCategoryResourceRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
* <p>
* 资源分类和资源关系表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-17
*/
public interface ResourceCategoryResourceRelationMapper extends BaseMapper<ResourceCategoryResourceRelation> {

    @Select("SELECT  urcrr.* FROM upms_resource_category_resource_relation as urcrr WHERE " +
            "urcrr.resource_category_id = #{categoryId} and urcrr.resource_id = #{resourceId}")
    ResourceCategoryResourceRelation get(Long categoryId, Long resourceId);

}
