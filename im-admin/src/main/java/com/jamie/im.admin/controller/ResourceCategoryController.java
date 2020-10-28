package com.jamie.im.admin.controller;

import com.jamie.im.admin.domain.ResourceCategory;
import com.jamie.im.admin.service.ResourceCategoryService;
import com.jamie.im.common.base.BaseController;
import com.jamie.im.common.response.ResponseResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
* 资源分类表 前端控制器
* </p>
*
* @author jamie
* @since 2020-10-14
*/
@RestController
@RequestMapping("resourceCategory")
public class ResourceCategoryController extends BaseController<ResourceCategory, ResourceCategoryService>  {

    @GetMapping("/listAll")
    public ResponseResult listAll() {
        return ResponseResult.success(this.service.listAll());
    }

    @GetMapping("/get/{id}")
    public ResponseResult get(@PathVariable Long id){
        return ResponseResult.success(this.service.getResourceCategory(id));
    }

}
