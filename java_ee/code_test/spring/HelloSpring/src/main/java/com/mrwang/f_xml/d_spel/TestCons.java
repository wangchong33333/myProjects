package com.mrwang.f_xml.d_spel;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCons {

	@Test
	public void demo2() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String xmlPath = "com/mrwang/f_xml/d_spel/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		Customer customer = (Customer) applicationContext.getBean("customer");

		System.out.println(customer);
	}
}
