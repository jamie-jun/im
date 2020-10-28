package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Resource;
import com.jamie.im.admin.dto.ResourceDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* <p>
* 后台资源表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface ResourceMapper extends BaseMapper<Resource> {

    @Select("SELECT\n" +
            "\tur.* \n" +
            "FROM\n" +
            "\tupms_role_resource_relation AS urrr\n" +
            "\tLEFT JOIN upms_resource AS ur ON urrr.resource_id = ur.id \n" +
            "WHERE\n" +
            "\turrr.role_id = #{roleId}")
    List<Resource> listByRoleId(Long roleId);

    @Select("<script>" +
            "SELECT\n" +
            "\tur.* \n" +
            "FROM\n" +
            "\tupms_resource_category_resource_relation AS urcrr\n" +
            "\tLEFT JOIN upms_resource AS ur ON urcrr.resource_id = ur.id \n" +
            "<where>\n" +
            "\t<if test=\"categoryId != null and categoryId != ''\">\n urcrr.resource_category_id = #{categoryId}</if>" +
            "\t<if test=\"name != null and name != ''\">\n AND ur.NAME LIKE CONCAT('%',#{name},'%')</if>"  +
            "\t<if test=\"url != null and url != ''\">\n AND ur.url LIKE CONCAT('%',#{url},'%')</if>" +
            "</where>"+
            "</script> ")
   Page<ResourceDto> listInfo(Page<Resource> page,
                              @Param("categoryId") Long categoryId,
                              @Param("name") String nameKeyword,
                              @Param("url") String urlKeyword);
}
