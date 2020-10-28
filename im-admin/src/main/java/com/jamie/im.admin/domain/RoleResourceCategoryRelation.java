package com.jamie.im.admin.domain;

import com.jamie.im.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台角色资源分类关系表
 * </p>
 *
 * @author jamie
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_role_resource_category_relation")
@Accessors(chain = true)
public class RoleResourceCategoryRelation extends BaseDomain {

    private static final long serialVersionUID = -280954122454581649L;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 资源分类ID
     */
    @TableField("resource_category_id")
    private Long resourceCategoryId;

}
