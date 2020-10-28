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
* 后台用户权限表
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("upms_permission")
public class Permission extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 564879891689746523L;

    /**
    * 父级权限id
    */
    @TableField("pid")
    private Long pid;

    /**
    * 名称
    */
    @TableField("name")
    private String name;

    /**
    * 权限值
    */
    @TableField("value")
    private String value;

    /**
    * 图标
    */
    @TableField("icon")
    private String icon;

    /**
    * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
    */
    @TableField("type")
    private Integer type;

    /**
    * 前端资源路径
    */
    @TableField("uri")
    private String uri;

    /**
    * 启用状态；0->禁用；1->启用
    */
    @TableField("status")
    private Integer status;

    /**
    * 排序
    */
    @TableField("sort")
    private Integer sort;

}
