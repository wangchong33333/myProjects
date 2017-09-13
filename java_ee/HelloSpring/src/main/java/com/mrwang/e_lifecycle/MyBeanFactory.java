package com.mrwang.e_lifecycle;

public class MyBeanFactory {
	public UserService createService() {
		return new UserServiceImpl();
	}
}
