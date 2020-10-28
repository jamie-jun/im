package com.jamie.im.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jamie.im.common.response.ResponseCode;
import com.jamie.im.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@SuppressWarnings("all")
public abstract class BaseController<T extends BaseDomain,S extends BaseService<T>>{

    @Resource
    protected HttpServletRequest request;

    @Autowired
    protected S service;

    /**
     * 新增
     * @param t
     * @return
     */
    @PostMapping("create")
    public ResponseResult create(@Valid @RequestBody T t) {

        // 业务逻辑
        boolean created = service.create(t);
        if (created) {
            return ResponseResult.success("创建成功");
        }

        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResponseResult remove(@PathVariable Long id) {

        // 业务逻辑
        boolean deleted = service.remove(id);
        if (deleted) {
            return ResponseResult.success("删除成功");
        }

        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 修改
     * @param t
     * @return
     */
    @PutMapping("update")
    public ResponseResult update(@Valid @RequestBody T t) {

        // 业务逻辑
        boolean created = service.update(t);
        if (created) {
            return ResponseResult.success("修改成功");
        }

        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Long id) {

        // 业务逻辑
        T t = service.get(id);
        return ResponseResult.success(t);

    }

    /**
     * 分页查询
     * @param current 页码
     * @param size 笔数
     * @param admin 实体类
     * @return
     */
    @GetMapping("page")
    public ResponseResult get(@RequestParam int current, @RequestParam int size,
                              @ModelAttribute T t) {
        IPage<?> page = service.page(current, size, t);
        return ResponseResult.success(page);
    }
}
