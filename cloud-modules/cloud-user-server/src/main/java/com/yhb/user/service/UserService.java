package com.yhb.user.service;

import com.yhb.common.base.Result;

import java.util.List;

public interface UserService {

    Result<List<String>> getProviderData();
}
