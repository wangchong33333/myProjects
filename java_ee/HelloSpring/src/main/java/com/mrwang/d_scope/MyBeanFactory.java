package com.mrwang.d_scope;

public class MyBeanFactory {
	public UserService createService() {
		return new UserServiceImpl();
	}
}
