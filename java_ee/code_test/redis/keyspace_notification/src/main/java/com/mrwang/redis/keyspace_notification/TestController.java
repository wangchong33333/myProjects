package com.mrwang.redis.keyspace_notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/{text}")
    public String test(@PathVariable String text) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(text, text + text, 10, TimeUnit.SECONDS);
        return text;
    }
}
