package com.itmuch.cloud.microservicesimpleconsumermovie.feignclient;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
   private static final Logger logger= LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        logger.info("fallback; reason was: " + cause.getMessage());

        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user=new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
