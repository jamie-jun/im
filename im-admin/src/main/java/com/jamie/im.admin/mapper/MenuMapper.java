package com.jamie.im.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.dto.MenuDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
* <p>
* 后台菜单表 Mapper 接口
* </p>
*
* @author jamie
* @since 2020-10-12
*/
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("SELECT um.* FROM upms_administrator_role_relation as uarr LEFT JOIN upms_role_menu_relation as urmr \n" +
            "ON uarr.role_id = urmr.role_id LEFT JOIN upms_menu as um ON urmr.menu_id = um.id\n" +
            "WHERE uarr.user_id = #{userId}")
    List<MenuDto> findByUserId(Long userId);

    @Select("SELECT um.* FROM upms_menu as um ${ew.customSqlSegment}")
    Page<MenuDto> menuPage(Page<Menu> page, @Param(Constants.WRAPPER) Wrapper<Menu> wrapper);

    @Select("SELECT  um.* FROM upms_menu as um WHERE id = #{id}")
    MenuDto get(Long id);

}
