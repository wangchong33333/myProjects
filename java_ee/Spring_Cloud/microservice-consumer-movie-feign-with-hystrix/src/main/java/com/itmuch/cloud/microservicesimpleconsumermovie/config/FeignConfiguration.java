//package com.itmuch.cloud.microservicesimpleconsumermovie.config;
//
//import com.itmuch.cloud.microservicesimpleconsumermovie.interceptor.FeignGetRequestInterceptor;
//import com.itmuch.cloud.microservicesimpleconsumermovie.interceptor.TestRequestInterceptor;
//import feign.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////慎用，加了Configuration且被扫描到就是全局配置，feign全局拦截器无法被覆盖，feign client配置的拦截器比全局先执行
//@Configuration
//public class FeignConfiguration {
//
////配置此配置的client只能使用feign rest注解
////    @Bean
////    public Contract contractConfiguration(){
////        return new feign.Contract.Default();
////    }
//
////    @Bean
////    Logger.Level feignLoggerLevel() {
////        return Logger.Level.FULL;
////    }
//
//    @Bean
//    public TestRequestInterceptor testRequestInterceptor() {
//        return new TestRequestInterceptor();
//    }
//
//    @Bean
//    public FeignGetRequestInterceptor feignGetRequestInterceptor() {
//        return new FeignGetRequestInterceptor();
//    }
//
//}