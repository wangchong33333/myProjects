package com.mrwang.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.tx.service.AccountService;

public class TestApp {
	@Test
	public void demo1() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		AccountService accountService = (AccountService) applicationContext
				.getBean("accountService");
		accountService.transfer("jack", "rose", 1000);
	}
}
