package com.jamie.im.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Resource;
import com.jamie.im.admin.domain.ResourceCategory;
import com.jamie.im.admin.domain.ResourceCategoryResourceRelation;
import com.jamie.im.admin.domain.RoleResourceRelation;
import com.jamie.im.admin.dto.ResourceDto;
import com.jamie.im.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
* <p>
* 后台资源表 服务类
* </p>
*
* @author jamie
* @since 2020-10-14
*/
public interface ResourceService extends BaseService<Resource> {

    List<Resource> listAll();

    List<Resource> listByRoleId(Long id);

    @Transactional
    int delByRoleId(Long roleId);

    @Transactional
    int saveByRoleId(Long roleId, Map<String,List<String>> relationMap);

    List<RoleResourceRelation> fetchResourceAllRelation();

    List<ResourceCategoryResourceRelation> fetchResourceCateRelation();

    /**
     * 分页查询资源
     */
    Page<ResourceDto> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    int add(Long categoryId,Resource resource);

    int updateResource(Long categoryId,Resource resource);

    List<ResourceCategoryResourceRelation> getRelation();
}
