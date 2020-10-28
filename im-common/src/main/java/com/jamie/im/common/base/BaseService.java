package com.jamie.im.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
public interface BaseService<T extends BaseDomain>  extends IService<T> {

    /**
     * 新增
     * @param t
     * @return
     */
    boolean create(T t);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean remove(Long id);

    /**
     * 修改
     * @param t
     * @return
     */
    boolean update(T t);

    /**
     * 获取
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 分页
     * @param current
     * @param size
     * @param t
     * @return
     */
    IPage<?> page(int current, int size, T t);

}
