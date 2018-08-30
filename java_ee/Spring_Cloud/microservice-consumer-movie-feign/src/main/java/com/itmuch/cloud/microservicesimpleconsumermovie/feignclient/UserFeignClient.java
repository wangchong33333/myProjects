package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/simple/{id}")
    User findById(@PathVariable("id") Long id);

    @PostMapping("/user")
    User postUser(@RequestBody User user);

    @GetMapping("/get-user")
    User getUser(User user);

//    @RequestLine("GET /get-user")
//    User getUser(@QueryMap User user);
}