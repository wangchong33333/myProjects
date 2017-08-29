package com.mrwang.d_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {

	@Test
	public void demo2() {
		String xmlPath = "com/mrwang/d_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userService");
		UserService userService2 = (UserService) applicationContext.getBean("userService");
		
		System.out.println(userService);
		System.out.println(userService2);
	}
}
