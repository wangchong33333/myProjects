package com.mrwang.b_factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

	@Test
	public void demo01() {
		String path = "com/mrwang/b_factory_bean/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserService userService = (UserService) applicationContext
				.getBean("proxyService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
