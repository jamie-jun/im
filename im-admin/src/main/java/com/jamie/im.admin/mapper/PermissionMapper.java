package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamie.im.admin.domain.Permission;
import com.jamie.im.admin.dto.PermissionParam;
import java.util.List;

/**
* <p>
* 后台用户权限表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface PermissionMapper extends BaseMapper<Permission> {

    List<PermissionParam> findPermissionByUserId(Long userId);

}
