package com.jamie.im.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
@Accessors(chain = true)
public class MenuDto {

    /**
     * id
     */
    private String id;
    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端名称
     */
    private String name;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端隐藏
     */
    private Integer hidden;
}
