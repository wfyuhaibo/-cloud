package com.yhb.auth.controller;

import com.yhb.auth.service.impl.MyUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    /*@DeleteMapping(value = "/exit")
    public ResponseEntity revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return ResponseEntity.success();
        }
        return ResponseEntity.fail(ResultCode.EXITFAILED.getCode(),"操作失败");
    }*/

}
