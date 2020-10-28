package com.jamie.im.admin.domain;

import com.jamie.im.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台角色菜单关系表
 * </p>
 *
 * @author jamie
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_role_menu_relation")
@Accessors(chain = true)
public class RoleMenuRelation extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 4136171141007912457L;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Long menuId;

}
