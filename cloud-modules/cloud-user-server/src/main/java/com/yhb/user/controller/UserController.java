package com.yhb.user.controller;

import com.yhb.common.base.Result;
import com.yhb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${user-server.picture.basePath:}")
    private String basePath;

    @GetMapping("hello")
    @PreAuthorize("hasAnyAuthority('hello')")
    public String hello(){
        return "hello";
    }

    @GetMapping("current")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query() {
        return "具有query权限";
    }

    @GetMapping("config")
    public String testConfig() {
        return basePath;
    }

    @GetMapping("getData")
    public Result<List<String>> getProviderData() {
        return userService.getProviderData();
    }

}
