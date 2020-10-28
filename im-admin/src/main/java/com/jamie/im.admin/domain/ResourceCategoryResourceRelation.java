package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jamie.im.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 资源分类和资源关系表
 * </p>
 *
 * @author jamie
 * @since 2020-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_resource_category_resource_relation")
@Accessors(chain = true)
public class ResourceCategoryResourceRelation extends BaseDomain {


    private static final long serialVersionUID = 1430154307164771920L;

    /**
     * 资源分类ID
     */
    @TableField("resource_category_id")
    private Long resourceCategoryId;

    /**
     * 资源ID
     */
    @TableField("resource_id")
    private Long resourceId;

}
