//package com.itmuch.cloud.microservicesimpleconsumermovie.config;
//
//import com.itmuch.cloud.microservicesimpleconsumermovie.interceptor.FeignGetRequestInterceptor;
//import com.itmuch.cloud.microservicesimpleconsumermovie.interceptor.TestRequestInterceptor;
//import com.itmuch.cloud.microservicesimpleconsumermovie.interceptor.TestRequestInterceptor2;
//import feign.auth.BasicAuthRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//public class EurekaFeignClientConfiguration {
//
////    @Bean
////    public Contract contractConfiguration(){
////        return new feign.Contract.Default();
////    }
//
////    @Bean
////    public FeignGetRequestInterceptor feignGetRequestInterceptor(){
////        return new FeignGetRequestInterceptor();
////    }
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "123");
//    }
//
//    @Bean
//    public TestRequestInterceptor2 testRequestInterceptor2(){
//        return new TestRequestInterceptor2();
//    }
//}