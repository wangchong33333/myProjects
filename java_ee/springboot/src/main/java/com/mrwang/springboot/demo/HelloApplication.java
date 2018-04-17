package com.mrwang.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { RedisAutoConfiguration.class })
@ComponentScan(basePackages = "com.mrwang.springboot") // 配置扫描包
public class HelloApplication extends SpringBootServletInitializer {

//	@Bean
//	public StringHttpMessageConverter stringHttpMessageConverter() {
//		// StringHttpMessageConverter converter = new
//		// StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
//		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
//		return converter;
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HelloApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
