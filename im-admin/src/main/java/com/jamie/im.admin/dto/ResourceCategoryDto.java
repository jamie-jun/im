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
public class ResourceCategoryDto {

    /**
     * id
     */
    private String id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

}
