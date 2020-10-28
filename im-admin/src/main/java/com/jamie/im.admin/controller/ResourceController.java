package com.jamie.im.admin.controller;


import com.jamie.im.admin.domain.Resource;
import com.jamie.im.admin.service.ResourceService;
import com.jamie.im.common.base.BaseController;
import com.jamie.im.common.response.ResponseResult;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
* 后台资源表 前端控制器
* </p>
*
* @author jamie
* @since 2020-10-14
*/
@RestController
@RequestMapping("resource")
public class ResourceController extends BaseController<Resource, ResourceService>  {

    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('resource')")
    public ResponseResult listAll() {
        List<Resource> resourceList = this.service.listAll();
        return ResponseResult.success(resourceList);
    }

    @GetMapping("fetchResourceAllRelation")
    @PreAuthorize("hasAnyAuthority('resource','relation')")
    public ResponseResult fetchResourceAllRelation(){
        return ResponseResult.success(this.service.fetchResourceAllRelation());
    }

    @GetMapping("fetchResourceCateRelation")
    public ResponseResult fetchResourceCateRelation(){
        return ResponseResult.success(this.service.fetchResourceCateRelation());
    }

    @GetMapping("/list")
    public ResponseResult list(@RequestParam(required = false) Long categoryId,
                               @RequestParam(required = false) String nameKeyword,
                               @RequestParam(required = false) String urlKeyword,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return ResponseResult.success(this.service.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum));
    }

    @PostMapping("/create/{id}")
    public ResponseResult create(@PathVariable Long id,
                                 @RequestBody Resource resource){
        return ResponseResult.success(this.service.add(id,resource));
    }

    @PutMapping("/update/{id}")
    public ResponseResult updateResource(@PathVariable Long id,
                                 @RequestBody Resource resource){
          return ResponseResult.success(this.service.updateResource(id,resource));
    }

    @GetMapping("/getRelation")
    public ResponseResult getRelation(){
        return ResponseResult.success(this.service.getRelation());
    }
}
