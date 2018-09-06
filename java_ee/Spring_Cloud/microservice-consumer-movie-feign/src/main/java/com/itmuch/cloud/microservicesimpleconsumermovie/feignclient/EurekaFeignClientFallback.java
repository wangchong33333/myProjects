package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import org.springframework.stereotype.Component;

@Component
public class EurekaFeignClientFallback implements EurekaFeignClient{
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "haha";
    }
}
