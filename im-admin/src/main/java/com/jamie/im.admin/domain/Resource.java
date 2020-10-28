package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jamie.im.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * <p>
 * 后台资源表
 * </p>
 *
 * @author jamie
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_resource")
public class Resource extends BaseDomain {

    private static final long serialVersionUID = 7379807753680418885L;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源URL
     */
    @TableField("url")
    private String url;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

}
