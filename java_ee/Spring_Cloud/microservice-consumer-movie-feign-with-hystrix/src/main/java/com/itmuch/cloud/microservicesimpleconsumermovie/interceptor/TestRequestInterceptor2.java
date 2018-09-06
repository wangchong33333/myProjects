package com.itmuch.cloud.microservicesimpleconsumermovie.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRequestInterceptor2 implements RequestInterceptor {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("TestRequestInterceptor2");
    }
}