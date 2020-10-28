package com.jamie.im.common.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamie.im.common.exception.BusinessException;
import com.jamie.im.common.response.ResponseCode;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
public abstract class BaseServiceImpl<M extends BaseMapper<T>,T extends BaseDomain> extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 检查字段：ID
     */
    private static final String ID = "id";


    @Override
    public boolean create(T t) {
        return super.save(t);
    }

    @Override
    public boolean remove(Long id) {
        if(checkId(id)){
            return super.removeById(id);
        }
        return false;
    }

    @Override
    public boolean update(T t) {
        if(checkId(t.getId())){
            return super.updateById(t);
        }
        return false;
    }

    @Override
    public T get(Long id) {
        T t = super.getById(id);
        if(t == null){
            throw new BusinessException(ResponseCode.RESULT_DATA_NONE);
        }
        return t;
    }

    @Override
    public IPage<?> page(int current, int size, T t) {
        Page<T> page  = new Page<>(current,size);
        LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();
        return super.page(page,wrapper);
    }

    /**
     * 检查 ID 是否存在
     * @param id
     * @return 不存在抛出异常
     */
    protected boolean checkId(Long id){

        if(checkUniqueness(ID,id)){
            throw new BusinessException(ResponseCode.RESULT_DATA_NONE);
        }
        return true;
    }

    /**
     * 检查字段是否唯一
     * @param colum 字段
     * @param value 值
     * @return
     */
    protected boolean checkUniqueness(String colum,Object value){
        QueryWrapper<T> wrapper = new QueryWrapper();
        wrapper.eq(colum,value);
        return super.count(wrapper) < 0;
    }

}
