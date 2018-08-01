package com.mrwang.g_annotation.b_web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoIoC {

	@Test
	public void demo02() {
		String xmlPath = "com/mrwang/g_annotation/b_web/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		StudentAction userService = (StudentAction) applicationContext
				.getBean("studentAction");
		userService.execute();
	}
}
