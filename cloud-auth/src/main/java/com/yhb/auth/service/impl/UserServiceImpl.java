package com.yhb.auth.service.impl;

import com.yhb.auth.entity.PermissionDTO;
import com.yhb.auth.entity.RoleDTO;
import com.yhb.auth.entity.UserDTO;
import com.yhb.auth.repository.PermissionMapper;
import com.yhb.auth.repository.RoleMapper;
import com.yhb.auth.repository.UserMapper;
import com.yhb.auth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDTO findByName(String name) {
        UserDTO userDTO = userMapper.findByName(name);
        if (ObjectUtils.isEmpty(userDTO)) {
            return null;
        }

        //获取用户角色
        List<RoleDTO> roleList = roleMapper.findByUserId(userDTO.getId());
        if (!CollectionUtils.isEmpty(roleList)) {
            Set<RoleDTO> roles = new HashSet<>();
            for (RoleDTO roleDTO : roleList) {
                //获取角色对应的权限
                List<PermissionDTO> permissionList = permissionMapper.findByRoleId(roleDTO.getId());
                Set<PermissionDTO> permissions = new HashSet<>();
                permissions.addAll(copyTo(permissionList, PermissionDTO.class));
                roleDTO.setPermissions(permissions);
                roles.add(roleDTO);
            }
            userDTO.setRoles(roles);
        }

        return userDTO;
    }

    public static <E> List<E> copyTo(List<?> source, Class<E> destinationClass) {
        if (source.size() == 0) return Collections.emptyList();
        List<E> res = new ArrayList<>(source.size());
        try {
            for (Object o : source) {
                E e = destinationClass.newInstance();
                BeanUtils.copyProperties(o, e, destinationClass);
                res.add(e);
            }
        } catch (Exception e) {

        }
        return res;
    }


}
