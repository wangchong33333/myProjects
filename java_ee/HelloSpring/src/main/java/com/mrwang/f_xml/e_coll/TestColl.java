package com.mrwang.f_xml.e_coll;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestColl {

	@Test
	public void demo2() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String xmlPath = "com/mrwang/f_xml/e_coll/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		CollData collData = (CollData) applicationContext.getBean("collData");

		System.out.println(collData);
	}
}
