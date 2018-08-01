package com.mrwang.f_xml.b.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetter {

	@Test
	public void demo01() {
		String xmlPath = "com/mrwang/f_xml/b/setter/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		Person person = (Person) applicationContext.getBean("person");

		System.out.println(person);
	}
}
