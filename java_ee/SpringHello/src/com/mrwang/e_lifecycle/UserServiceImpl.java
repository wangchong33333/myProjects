package com.mrwang.e_lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("e_lifecycle_add_user");
	}

	public void myInit() {
		System.out.println("��ʼ��");
	}

	public void myDestroy() {
		System.out.println("����");
	}
}
