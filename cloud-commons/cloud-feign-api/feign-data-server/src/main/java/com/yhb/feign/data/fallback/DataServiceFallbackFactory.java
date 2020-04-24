package com.yhb.feign.data.fallback;


import com.yhb.common.base.Result;
import com.yhb.feign.data.service.DataServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class DataServiceFallbackFactory implements FallbackFactory<DataServiceFeign> {

    @Override
    public DataServiceFeign create(Throwable throwable) {
        return new DataServiceFeign() {

            @Override
            public Result getProviderData() {
                return null;
            }
        };
    }

}
