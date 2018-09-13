//package com.itmuch.cloud.microservicesimpleconsumermovie.config;
//
//import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
//import org.springframework.cloud.client.actuator.FeaturesEndpoint;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class WebSecurityConfig {
//
//
//    @Bean
//    public SecurityWebFilterChain securitygWebFilterChain(
//      ServerHttpSecurity http) {
//        return  http
//
//            .authorizeExchange()
//                .pathMatchers("/**").permitAll().anyExchange().permitAll().and().csrf().disable().build();
//    }
//
//}