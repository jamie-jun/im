package com.jamie.im.admin.controller;

import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.domain.Resource;
import com.jamie.im.admin.domain.Role;
import com.jamie.im.admin.service.RoleService;
import com.jamie.im.common.base.BaseController;
import com.jamie.im.common.response.ResponseResult;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
* <p>
* 后台用户角色表 前端控制器
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@RestController
@RequestMapping("role")
public class RoleController extends BaseController<Role, RoleService> {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public ResponseResult getAll(){
        return ResponseResult.success(roleService.getAll());
    }

    @GetMapping("/list")
    public ResponseResult getRoleList(@RequestParam Long adminId){
        return ResponseResult.success(roleService.getRoleList(adminId));
    }

    @GetMapping("/roles")
    public ResponseResult getAll(@RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return ResponseResult.success(roleService.roles(keyword,pageSize,pageNum));
    }

    @PostMapping("/update")
    public ResponseResult updateRole (@RequestParam("adminId") Long adminId,
                                  @RequestParam("roleIds") List<Long> roleIds){
        return ResponseResult.success(roleService.updateRole(adminId,roleIds));
    }

    /**
     * 给角色分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping("/allocMenu")
    public ResponseResult allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        return ResponseResult.success(roleService.allocMenu(roleId, menuIds));
    }

    /**
     * 查询角色对应的菜单
     * @param roleId
     * @return
     */
    @GetMapping("/listMenu/{roleId}")
    public ResponseResult listMenu(@PathVariable Long roleId) {
        List<Menu> roleList = roleService.listMenu(roleId);
        return ResponseResult.success(roleList);
    }

    /**
     * 获取角色相关资源
     */
    @GetMapping("/listResource/{roleId}")
    public ResponseResult listResouce(@PathVariable Long roleId) {
        List<Resource> roleList = roleService.listResource(roleId);
        return ResponseResult.success(roleList);
    }

    /**
     * 给角色分配资源
     */
    @PostMapping("/allocResource/{roleId}")
    public ResponseResult allocResource(@PathVariable Long roleId,
                                        @RequestBody Map<String,List<String>> relationMap) {
        int count = roleService.allocResource(roleId, relationMap);
        return ResponseResult.success(count);
    }
}
