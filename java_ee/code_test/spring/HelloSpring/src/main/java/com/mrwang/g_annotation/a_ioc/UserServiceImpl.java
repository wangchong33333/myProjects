package com.mrwang.g_annotation.a_ioc;

import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("g_annotation.a_ioc add_user");
	}

}
