package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//fallback = UserFeignClientFallback.class,不能喝fallbackFacktory连用
@FeignClient(name = "microservice-provider-user",
fallbackFactory = UserFeignClientFallbackFactory.class)
//, configuration = FeignConfiguration.class
public interface UserFeignClient {
    @GetMapping("/simple/{id}")
    User findById(@PathVariable("id") Long id);
}