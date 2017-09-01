package com.mrwang.e_lifecycle;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {

	@Test
	public void demo2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String xmlPath = "com/mrwang/e_lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		UserService userService = (UserService) applicationContext
				.getBean("userService");
		userService.addUser();
		
//		applicationContext.getClass().getMethod("close").invoke(applicationContext);
		
		applicationContext.close();
	}
}
