package com.mrwang.g_annotation.c_other;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userService")
//@Scope("prototype")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("d_scope_add_user");
	}

	@PostConstruct
	public void myInit() {
		System.out.println("初始化");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("销毁");
	}

}
