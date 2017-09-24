package com.mrwang.g_annotation.c_other;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOther {

	@Test
	public void demo2() {
		String xmlPath = "com/mrwang/g_annotation/c_other/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		UserService userService = (UserService) applicationContext
				.getBean("userService");
		UserService userService2 = (UserService) applicationContext
				.getBean("userService");

		System.out.println(userService);
		System.out.println(userService2);

		applicationContext.close();
	}
}
