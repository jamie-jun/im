package com.jamie.im.admin.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jamie.im.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jamie
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("upms_administrator")
public class Administrator extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 7601437786733137776L;

    /**
     * 账号
     */
    @NotBlank(message = "账号为必填项")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码为必填项")
    @Length(min = 6,max = 20,message = "密码长度在6-20位数字之间")
    private String password;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称为必填项")
    private String nickname;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱为必填项")
    @Email(message = "请输入正确的邮箱地址")
    private String email;

    /**
     * 用户状态：1（已删除）0（已启用）
     */
    private Integer status;

    /**
     * 逻辑删除：1（已删除）0（未删除）
     */
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
