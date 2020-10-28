package com.jamie.im.admin.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class AdminAddParam {

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

}
