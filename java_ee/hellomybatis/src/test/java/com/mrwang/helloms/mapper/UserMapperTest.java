package com.mrwang.helloms.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.helloms.po.User;

public class UserMapperTest {
	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"config/spring/applicationContext.xml");
	}

	@Test
	public void test() throws Exception {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

}
