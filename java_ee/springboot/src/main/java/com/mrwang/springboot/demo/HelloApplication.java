package com.mrwang.springboot.demo;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = { RedisAutoConfiguration.class })
public class HelloApplication extends SpringBootServletInitializer {

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello world！雷猴啊";
	}

	// @Bean
	// public StringHttpMessageConverter stringHttpMessageConverter() {
	// StringHttpMessageConverter converter = new
	// StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
	// return converter;
	// }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HelloApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
