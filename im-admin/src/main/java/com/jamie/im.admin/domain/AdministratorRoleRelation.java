package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jamie.im.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author jamie
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("upms_administrator_role_relation")
public class AdministratorRoleRelation extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1424521439635870752L;

    /**
     * 用户 ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 角色 ID
     */
    @TableField("role_id")
    private Long roleId;

}
