package com.jamie.im.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Menu;
import com.jamie.im.admin.domain.Resource;
import com.jamie.im.common.base.BaseService;
import com.jamie.im.admin.domain.Role;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
* <p>
* 后台用户角色表 服务类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
public interface RoleService extends BaseService<Role> {

    /**
     * 获取用户对于角色
     */
    List<com.jamie.im.admin.dto.Role> getRoleList(Long adminId);

    /**
     * 获取全部角色
     *
     * @return
     */
    Page<com.jamie.im.admin.dto.Role> roles(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 分配角色
     */
    @Transactional
    int updateRole(Long adminId,List<Long> roleIds);

    /**
     * 删除用户角色关系
     */
    int delRole(Long adminId);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 获取角色相关菜单
     */
    List<Menu> listMenu(Long roleId);

    /**
     * 获取全部角色
     * @return
     */
    List<com.jamie.im.admin.dto.Role> getAll();

    /**
     * 获取角色相关资源
     * @param roleId
     * @return
     */
    List<Resource> listResource(Long roleId);

    /**
     * 给角色分配资源
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Transactional
    int allocResource(Long roleId, Map<String,List<String>> relationMap);

}
