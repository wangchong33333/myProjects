package com.mrwang.g_annotation.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoIoC {

	@Test
	public void demo02() {
		String xmlPath = "com/mrwang/g_annotation/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		UserService userService = (UserService) applicationContext
				.getBean("UserService");
		userService.addUser();
	}
}
