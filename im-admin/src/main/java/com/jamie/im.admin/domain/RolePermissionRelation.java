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
 * 角色权限表
 * </p>
 *
 * @author jamie
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("upms_role_permission_relation")
public class RolePermissionRelation extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 8277412490904440548L;

    /**
     * 角色 ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 权限 ID
     */
    @TableField("permission_id")
    private Long permissionId;

}
