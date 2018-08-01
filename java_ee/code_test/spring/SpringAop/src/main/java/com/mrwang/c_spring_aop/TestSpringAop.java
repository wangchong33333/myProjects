package com.mrwang.c_spring_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAop {

	@Test
	public void demo01() {
		String path = "com/mrwang/c_spring_aop/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserService userService = (UserService) applicationContext
				.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
