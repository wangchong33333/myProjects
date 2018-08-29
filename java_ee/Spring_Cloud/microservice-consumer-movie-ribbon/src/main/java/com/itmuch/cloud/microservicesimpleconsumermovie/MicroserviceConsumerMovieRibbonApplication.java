package com.itmuch.cloud.microservicesimpleconsumermovie;

import com.itmuch.cloud.microservicesimpleconsumermovie.anotation.ExcludeFromComponentScan;
import com.itmuch.cloud.microservicesimpleconsumermovie.config.ignore.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.itmuch.cloud.microservicesimpleconsumermovie.config.ignore.*")})
public class MicroserviceConsumerMovieRibbonApplication {

    @Bean
    @LoadBalanced //加了这个才能使用vip
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
    }
}
