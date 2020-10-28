package com.jamie.im.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.dto.MenuDto;
import com.jamie.im.admin.dto.MenuNode;
import com.jamie.im.admin.mapper.MenuMapper;
import com.jamie.im.admin.service.MenuService;
import com.jamie.im.common.base.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
* <p>
* 后台菜单表 服务实现类
* </p>
*
* @author jamie
* @since 2020-10-12
*/
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean create(Menu menu) {
        updateLevel(menu);
        return super.create(menu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(Menu menu) {
        if (menu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            menu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            Menu parentMenu = menuMapper.selectById(menu.getParentId());
            if (parentMenu != null) {
                menu.setLevel(parentMenu.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }

    @Override
    public List<MenuNode> treeList() {
        List<Menu> menus = menuMapper.selectList(new LambdaQueryWrapper<>());
        List<MenuNode> result = menus.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menus)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<MenuDto> findByUserId(Long userId) {
        return menuMapper.findByUserId(userId);
    }

    @Override
    public Page<MenuDto> list(Long parentId, Integer pageSize, Integer pageNum) {
        Page<Menu> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId,parentId);
        wrapper.orderByDesc(Menu::getSort);
        return menuMapper.menuPage(page,wrapper);
    }

    /**
     * 将UpmsMenu转化为MenuNode并设置children属性
     */
    private MenuNode covertMenuNode(Menu menu, List<Menu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    @Override
    public MenuDto getMenu(Long id) {
        return menuMapper.get(id);
    }

}
