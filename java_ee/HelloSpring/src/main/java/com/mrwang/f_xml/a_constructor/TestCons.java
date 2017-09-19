package com.mrwang.f_xml.a_constructor;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCons {

	@Test
	public void demo2() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String xmlPath = "com/mrwang/f_xml/a_constructor/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		User user = (User) applicationContext.getBean("user");

		System.out.println(user);
	}
}
