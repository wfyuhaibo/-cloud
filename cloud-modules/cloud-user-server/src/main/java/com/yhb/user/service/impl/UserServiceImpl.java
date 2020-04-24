package com.yhb.user.service.impl;

import com.yhb.common.base.Result;
import com.yhb.feign.data.service.DataServiceFeign;
import com.yhb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DataServiceFeign dataServiceFeign;

    @Override
    public Result<List<String>> getProviderData() {
        return dataServiceFeign.getProviderData();
    }
}
