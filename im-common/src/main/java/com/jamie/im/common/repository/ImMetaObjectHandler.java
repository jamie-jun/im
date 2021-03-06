package com.jamie.im.common.repository;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author: jamie
 * @since v:1.0.0
 **/

@Component
public class ImMetaObjectHandler implements MetaObjectHandler{

    /**
     * 通用字段：创建时间
     */
    private static final String CREATE_TIME = "createTime";
    /**
     * 通用字段：修改时间
     */
    private static final String UPDATE_TIME = "updateTime";
    /**
     * 通用字段：逻辑删除
     */
    private static final String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {

        //判断是否有相关字段
        boolean hasCreateTime = metaObject.hasSetter(CREATE_TIME);
        boolean hasUpdateTime = metaObject.hasSetter(UPDATE_TIME);
        boolean hasDeleted = metaObject.hasSetter(DELETED);

        //有字段填充字段
        if(hasCreateTime){
            strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        if(hasUpdateTime){
            strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        if(hasDeleted){
            strictInsertFill(metaObject, DELETED, Boolean.class, false);

        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        Object val = getFieldValByName(UPDATE_TIME, metaObject);

        //没有自定义值才填充
        if(val == null){
            strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
    }
}
