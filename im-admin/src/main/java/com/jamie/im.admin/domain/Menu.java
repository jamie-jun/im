package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jamie.im.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author jamie
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_menu")
public class Menu extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1704835109172354278L;

    /**
     * 父级ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 菜单名称
     */
    @TableField("title")
    private String title;

    /**
     * 菜单级数
     */
    @TableField("level")
    private Integer level;

    /**
     * 菜单排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 前端名称
     */
    @TableField("name")
    private String name;

    /**
     * 前端图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 前端隐藏
     */
    @TableField("hidden")
    private Integer hidden;

}
