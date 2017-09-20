package com.mrwang.f_xml.c_p;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetter {

	@Test
	public void demo01() {
		String xmlPath = "com/mrwang/f_xml/c_p/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		Person person = (Person) applicationContext.getBean("person");

		System.out.println(person);
	}
}
