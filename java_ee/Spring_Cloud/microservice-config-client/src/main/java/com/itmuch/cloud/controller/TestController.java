package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${profile}")
    private String profile;

    @GetMapping("")
    public String getProfile() {
        return profile;
    }
}
