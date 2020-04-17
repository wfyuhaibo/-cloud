package com.yhb.auth.service;

import com.yhb.auth.entity.UserDTO;

public interface UserService {

    /**
     * 根据会员名查找会员
     *
     * @param name 会员名
     * @return 会员
     */
    UserDTO findByName(String name);
}
