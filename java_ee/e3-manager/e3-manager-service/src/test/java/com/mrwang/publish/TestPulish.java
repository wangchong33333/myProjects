package com.mrwang.publish;

import org.junit.Test;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPulish {
	@Test
	public void publishService() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext*.xml");
		// while (true) {
		// Thread.sleep(1000);
		// }
		System.out.println("服务已启动。。。");
		System.in.read();
		System.out.println("服务已关闭。。。");
	}
}
