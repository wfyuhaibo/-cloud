package com.yhb.feign.data.service;

import com.yhb.common.base.Result;
import com.yhb.feign.data.fallback.DataServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "cloud-data-server", fallbackFactory = DataServiceFallbackFactory.class)
public interface DataServiceFeign {

    @GetMapping(value = "api/getProviderData")
    Result getProviderData();

}
