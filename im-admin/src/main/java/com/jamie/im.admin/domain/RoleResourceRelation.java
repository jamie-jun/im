package com.jamie.im.admin.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jamie.im.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台角色资源分类资源关系表
 * </p>
 *
 * @author jamie
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_role_resource_relation")
@Accessors(chain = true)
public class RoleResourceRelation extends BaseDomain {

    private static final long serialVersionUID = -2590999093067194382L;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 资源ID
     */
    @TableField("resource_id")
    private Long resourceId;

}
