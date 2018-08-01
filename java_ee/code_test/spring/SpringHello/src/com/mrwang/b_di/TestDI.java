package com.mrwang.b_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	@Test
	public void demo01() {
		String xmlPath = "com/mrwang/di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		BookService bookService = (BookService) applicationContext
				.getBean("BookService");
		bookService.addBook();
	}
}
