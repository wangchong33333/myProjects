package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}