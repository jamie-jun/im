package com.jamie.im.admin.dto;

import com.jamie.im.admin.domain.Permission;
import lombok.Data;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class PermissionParam extends Permission {

    private Long userId;

}
