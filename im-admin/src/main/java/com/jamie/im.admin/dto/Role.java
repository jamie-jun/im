package com.jamie.im.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
@Accessors(chain = true)
public class Role{

    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    private Integer adminCount;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

}
