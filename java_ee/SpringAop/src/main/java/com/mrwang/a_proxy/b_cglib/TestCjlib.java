package com.mrwang.a_proxy.b_cglib;

import org.junit.Test;

public class TestCjlib {

	@Test
	public void demo01() {
		UserServiceImpl userService = MyBeanFactory.creatService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
