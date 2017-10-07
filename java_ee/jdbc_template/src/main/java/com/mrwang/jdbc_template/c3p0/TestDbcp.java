package com.mrwang.jdbc_template.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.jdbc_template.domain.User;

public class TestDbcp {

	@Test
	public void demo1() {
		User user = new User();
		user.setId(1);
		user.setUsername("油");
		user.setPassword("999");

		String path = "com/mrwang/jdbc_template/dpcp/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.update(user);
	}
}
