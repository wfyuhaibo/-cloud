package com.yhb.auth.repository;

import com.yhb.auth.entity.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 根据会员名查找会员
     * @param name 会员名
     * @return 会员
     */
    UserDTO findByName(String name);
}
