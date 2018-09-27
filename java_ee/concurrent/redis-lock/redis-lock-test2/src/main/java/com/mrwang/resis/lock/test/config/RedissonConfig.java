package com.mrwang.resis.lock.test.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redisson() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.123.118:6379");
        // 2. Create Redisson instance
        return Redisson.create(config);
    }
}
