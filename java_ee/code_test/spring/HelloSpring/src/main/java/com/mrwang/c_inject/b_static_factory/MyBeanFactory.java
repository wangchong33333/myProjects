package com.mrwang.c_inject.b_static_factory;

public class MyBeanFactory {
	public static UserService createService() {
		return new UserServiceImpl();
	}
}
