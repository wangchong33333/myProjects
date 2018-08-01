package com.mrwang.d_aspect.b_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {

	@Test
	public void demo01() {
		String path = "com/mrwang/d_aspect/b_anno/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserService userService = (UserService) applicationContext
				.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
