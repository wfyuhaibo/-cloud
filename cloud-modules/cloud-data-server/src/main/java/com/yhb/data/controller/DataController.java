package com.yhb.data.controller;

import com.yhb.common.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DataController {

    @ApiOperation(value = "获取提供的数据")
    @GetMapping("/getProviderData")
    public Result<List<String>> getProviderData(){
        List<String> provider = new ArrayList<String>();
        provider.add("Beijing Company");
        provider.add("Shanghai Company");
        provider.add("Shenzhen Company");
        return Result.success(provider);
    }

}
