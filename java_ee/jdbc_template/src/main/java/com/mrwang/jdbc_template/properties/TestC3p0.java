package com.mrwang.jdbc_template.properties;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.jdbc_template.domain.User;

public class TestC3p0 {

	@Test
	public void demo1() {
		User user = new User();
		user.setId(2);
		user.setUsername("油");
		user.setPassword("999");

		String path = "com/mrwang/jdbc_template/properties/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				path);
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// userDao.update(user);
		// List<User> users = userDao.findAll();
		// for (User user2 : users) {
		// System.out.println(user2);
		// }
		System.out.println(userDao.getById(1));
	}
}
