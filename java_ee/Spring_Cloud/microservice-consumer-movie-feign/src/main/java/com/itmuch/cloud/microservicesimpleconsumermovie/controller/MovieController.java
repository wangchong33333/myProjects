package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import com.itmuch.cloud.microservicesimpleconsumermovie.feignclient.EurekaFeignClient;
import com.itmuch.cloud.microservicesimpleconsumermovie.feignclient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("/get-user")
    public User getUser(User user) {
        return userFeignClient.getUser(user);
    }

    @GetMapping("/eureka/apps/{serviceName}")
    public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return eurekaFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
