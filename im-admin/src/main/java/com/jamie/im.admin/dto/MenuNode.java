package com.jamie.im.admin.dto;

import com.jamie.im.admin.domain.Menu;
import lombok.Data;
import java.util.List;

/**
 * 后台菜单节点封装
 * Created by macro on 2020/2/4.
 */

@Data
public class MenuNode extends Menu {

    /**
     * 子级菜单
     */
    private List<MenuNode> children;

}
