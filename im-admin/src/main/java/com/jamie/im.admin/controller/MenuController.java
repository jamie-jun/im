package com.jamie.im.admin.controller;

import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.service.MenuService;
import com.jamie.im.common.base.BaseController;
import com.jamie.im.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* <p>
* 后台菜单表 前端控制器
* </p>
*
* @author jamie
* @since 2020-10-12
*/
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController<Menu, MenuService> {

    @Autowired
    private MenuService menuService;

    /**
     * 树形结构返回所有菜单列表
     * @return
     */
    @GetMapping("/treeList")
    public ResponseResult treeList() {
        return ResponseResult.success(menuService.treeList());
    }

    @GetMapping("/list/{parentId}")
    public ResponseResult list(@PathVariable Long parentId,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return ResponseResult.success(this.service.list(parentId,pageSize,pageNum));
    }

    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Long id){
        return ResponseResult.success(this.service.getMenu(id));
    }

    @PostMapping("/update/{id}")
    public ResponseResult update(@PathVariable Long id,@RequestBody Menu menu){
        return ResponseResult.success(super.update(menu));
    }
}
