package com.jamie.im.auth.controller.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginParam implements Serializable {

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
