package com.mrwang.helloms.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.helloms.po.User;

public class UserDaoTest {
	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"config/spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDao dao = (UserDao) ctx.getBean("userDao");
		User user = dao.findUserById(1);
		System.out.println(user);
	}
}
