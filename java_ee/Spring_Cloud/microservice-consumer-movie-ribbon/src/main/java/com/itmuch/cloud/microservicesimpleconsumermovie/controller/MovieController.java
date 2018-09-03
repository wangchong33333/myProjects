package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("test")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111:" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("222:" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

        return "1";
    }

    @GetMapping("/get-users")
    public List<User> getUsers() {
        List<User> users = restTemplate.getForObject("http://microservice-provider-user/get-users", List.class);
        return users;
    }

}
