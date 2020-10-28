package com.jamie.im.admin.domain;

import com.jamie.im.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源分类表
 * </p>
 *
 * @author jamie
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_resource_category")
@Accessors(chain = true)
public class ResourceCategory extends BaseDomain {

    private static final long serialVersionUID = 8536401040494783112L;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

}
