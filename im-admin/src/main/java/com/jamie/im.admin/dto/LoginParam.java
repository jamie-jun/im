package com.jamie.im.admin.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class LoginParam {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

}
