package com.mrwang.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.common.jedis.JedisClient;

public class JedisClientTest {
	@Test
	public void testJedisClient() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-redis.xml");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("mytest", "jedisClient");
		String string = jedisClient.get("mytest");
		System.out.println(string);
	}
}
