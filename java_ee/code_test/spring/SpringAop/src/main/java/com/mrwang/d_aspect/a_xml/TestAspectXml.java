package com.mrwang.d_aspect.a_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectXml {

	@Test
	public void demo01() {
		String path = "com/mrwang/d_aspect/a_xml/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserService userService = (UserService) applicationContext
				.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
