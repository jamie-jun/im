package com.jamie.im.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = -9215521889972704058L;

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

//    /**
//     * 创建时间
//     */
//    @TableField(value = "create_time",fill = FieldFill.INSERT)
//    private LocalDateTime createTime;
//
//    /**
//     * 修改时间
//     */
//    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateTime;

}
