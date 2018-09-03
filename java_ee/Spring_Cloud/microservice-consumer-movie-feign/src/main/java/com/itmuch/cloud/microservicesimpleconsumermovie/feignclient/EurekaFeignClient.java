package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import com.itmuch.cloud.microservicesimpleconsumermovie.config.EurekaFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "xxxx", url = "http://localhost:8761", configuration = EurekaFeignClientConfiguration.class)
public interface EurekaFeignClient {
    @GetMapping("/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
