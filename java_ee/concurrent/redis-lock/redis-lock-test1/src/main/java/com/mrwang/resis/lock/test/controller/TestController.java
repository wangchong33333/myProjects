package com.mrwang.resis.lock.test.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private Lock reentrantLock = new ReentrantLock();

    @GetMapping("/test1")
    public String test() {
        reentrantLock.lock();
        redisTemplate.opsForValue().set("redis:lock:test", "123", 3600L, TimeUnit.SECONDS);
        try {
            System.out.println("sleep_start");
            Thread.sleep(30000L);
            System.out.println("sleep_over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
        return "ok";
    }

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/test")
    public String redisTest() {
        RLock lock = redissonClient.getLock("myLock");
        lock.lock();
        redisTemplate.opsForValue().set("redis:lock:test", "123", 3600L, TimeUnit.SECONDS);
        try {
            System.out.println("sleep_start");
            Thread.sleep(30000L);
            System.out.println("sleep_over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return "ok";
    }
}