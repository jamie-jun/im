package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Administrator;
import com.jamie.im.admin.dto.AdminCommonParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* <p>
* 用户表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface AdministratorMapper extends BaseMapper<Administrator> {

    @Select("select ua.* from upms_administrator as ua ${ew.customSqlSegment}")
    Page<AdminCommonParam> select(Page<AdminCommonParam> page, @Param(Constants.WRAPPER)Wrapper<AdminCommonParam> wrapper);

}
