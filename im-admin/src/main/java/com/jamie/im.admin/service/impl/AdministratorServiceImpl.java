package com.jamie.im.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamie.im.admin.domain.Permission;
import com.jamie.im.admin.dto.AdminAddParam;
import com.jamie.im.admin.dto.AdminCommonParam;
import com.jamie.im.admin.dto.PermissionParam;
import com.jamie.im.admin.service.AuthService;
import com.jamie.im.admin.service.PermissionService;
import com.jamie.im.admin.service.RoleService;
import com.jamie.im.common.base.BaseServiceImpl;
import com.jamie.im.common.dto.UserDto;
import com.jamie.im.admin.domain.Administrator;
import com.jamie.im.admin.mapper.AdministratorMapper;
import com.jamie.im.admin.service.AdministratorService;
import com.jamie.im.common.response.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* <p>
* 用户表 服务实现类
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@Service
public class AdministratorServiceImpl extends BaseServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private AdministratorMapper upmsUserMapper;

    @Autowired
    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;
//    /**
//     * 账号
//     */
//    private static final String USERNAME = "username";
//    /**
//     * 昵称
//     */
//    private static final String NICKNAME = "nickname";
//    /**
//     * 邮箱
//     */
//    private static final String EMAIL = "email";
//
//    @Override
//    public boolean create(UpmsUser user) {
//        if(!chackUsername(user.getUsername())
//                && !chackNickname(user.getNickname())
//                && !chackEmail(user.getEmail())){
//            user.setStatus(UserStatus.CLOSEO);
//            return super.save(user);
//        }
//        return false;
//    }
//
//    public IPage<UpmsUser> page(int current, int size, UpmsUser user) {
//        Page<UpmsUser> page = new Page<>(current,size);
//
//        //查询条件
//        if(null != user){
//            LambdaQueryWrapper<UpmsUser> wrapper = new LambdaQueryWrapper();
//            wrapper
//                    .eq(StringUtils.isNotBlank(String.valueOf(user.getId())),UpmsUser::getId,user.getId())
//                    .or().like(StringUtils.isNotBlank(user.getUsername()),UpmsUser::getUsername,user.getUsername())
//                    .or().like(StringUtils.isNotBlank(user.getNickname()),UpmsUser::getNickname,user.getNickname())
//                    .or().like(StringUtils.isNotBlank(user.getEmail()),UpmsUser::getEmail,user.getEmail());
//            return super.page(page,wrapper);
//        }
//        return super.page(page,null);
//    }

//    /**
//     * 插件用户名是否存在
//     * @param username
//     * @return
//     */
//    public boolean chackUsername(String username){
//        if(checkUniqueness("USERNAME",username)){
//            throw new BusinessException(ResponseCode.USER_HAS_EXISTED);
//        }
//        return false;
//    }
//
//
//    public boolean chackNickname(String nickname){
//        if(checkUniqueness("NICKNAME",nickname)){
//            throw new BusinessException(ResponseCode.USER_NICE_HAS_EXISTED);
//        }
//        return false;
//    }
//
//    public boolean chackEmail(String email){
//        if(checkUniqueness("EMAIL",email)){
//            throw new BusinessException(ResponseCode.USER_EMAIL_HAS_EXISTED);
//        }
//        return false;
//    }

    @Override
    public UserDto loadUserByUsername(String username) {
        Administrator user = getAdminByUsername(username);
        if(user == null){
            return null;
        }
        List<String> permissions = getRoleList(user.getId())
                .stream()
                .map(Permission::getValue).collect(Collectors.toList());
        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(user,userDto);
        userDto.setRoles(permissions);
        return userDto;
    }

    @Override
    public ResponseResult login(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "im_admin");
        params.put("client_secret","secret");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        Map token = authService.getAccessToken(params);
        return ResponseResult.success(MapUtil.getStr(token, "access_token"));
    }

    @Override
    public Administrator register(AdminAddParam adminParam) {
        Administrator user = new Administrator();
        BeanUtils.copyProperties(adminParam, user);
        //查询是否有相同用户名的用户
        Administrator username = getAdminByUsername(user.getUsername());
        if (username !=null) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setDeleted(false);
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(1);
        user.setUpdateTime(LocalDateTime.now());
        upmsUserMapper.insert(user);
        return user;
    }

    @Override
    public Page<AdminCommonParam> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<AdminCommonParam> page  = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<AdminCommonParam> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(keyword),AdminCommonParam::getUsername,keyword).or()
                .like(StringUtils.isNotBlank(keyword),AdminCommonParam::getNickname,keyword);
        return upmsUserMapper.select(page, wrapper);
    }

    @Override
    public Administrator updateUser(AdminCommonParam updateParam) {
        Administrator user = new Administrator();
        BeanUtil.copyProperties(updateParam,user);
        //密码不同更改原来密码
        Administrator upmsUser = upmsUserMapper.selectById(user.getId());
        if(!upmsUser.getPassword().equals(user.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        user.setUpdateTime(LocalDateTime.now());
        upmsUserMapper.updateById(user);
        return user;
    }

    @Override
    public int del(Long adminId) {
        //删除用户对应角色关系
        roleService.delRole(adminId);
        //删除用户
        int u = upmsUserMapper.deleteById(adminId);
        return u;
    }

    @Override
    public Administrator getAdminByUsername(String username) {
        LambdaQueryWrapper<Administrator> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Administrator::getUsername,username);
        return upmsUserMapper.selectOne(wrapper);
    }

    @Override
    public List<PermissionParam> getRoleList(Long adminId) {
        return permissionService.findPermissionByUserId(adminId);
    }

}
