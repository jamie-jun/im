package com.jamie.im.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.dto.MenuDto;
import com.jamie.im.admin.dto.MenuNode;
import com.jamie.im.common.base.BaseService;

import java.util.List;

/**
* <p>
* 后台菜单表 服务类
* </p>
*
* @author jamie
* @since 2020-10-12
*/
public interface MenuService extends BaseService<Menu> {

    /**
     * 树形结构返回所有菜单列表
     */
    List<MenuNode> treeList();

    List<MenuDto> findByUserId(Long userId);

    /**
     * 分页查询后台菜单
     */
    Page<MenuDto> list(Long parentId, Integer pageSize, Integer pageNum);

    MenuDto getMenu(Long id);

}
