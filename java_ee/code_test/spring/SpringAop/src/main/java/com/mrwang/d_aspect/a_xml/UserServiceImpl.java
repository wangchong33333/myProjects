package com.mrwang.d_aspect.a_xml;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("d_aspect.a_xml addUser");
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		int i = 1 / 0;
		System.out.println("d_aspect.a_xml updateUser");
	}

	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("d_aspect.a_xml deleteUser");
		return "油~";
	}

}
