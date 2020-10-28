package com.jamie.im.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class RoleParam {

    private String name;

    private String description;

    private Integer adminCount;

    private Date createTime;

    private Integer status;

    private Integer sort;
}
