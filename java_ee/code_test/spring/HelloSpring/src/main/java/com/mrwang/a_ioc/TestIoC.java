package com.mrwang.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {

	@Test
	public void demo01() {
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}

	@Test
	public void demo02() {
		String xmlPath = "com/mrwang/ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		UserService userService = (UserService) applicationContext
				.getBean("UserService");
		userService.addUser();
	}
}
