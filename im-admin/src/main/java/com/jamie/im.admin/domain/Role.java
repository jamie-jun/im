package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jamie.im.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author jamie
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("upms_role")
public class Role extends BaseDomain implements Serializable{

    private static final long serialVersionUID = -2875664692266334340L;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 后台用户数量
     */
    @TableField("admin_count")
    private Integer adminCount;

    /**
     * 启用状态：0->禁用；1->启用
     */
    @TableField("status")
    private Integer status;

    @TableField("sort")
    private Integer sort;

}
