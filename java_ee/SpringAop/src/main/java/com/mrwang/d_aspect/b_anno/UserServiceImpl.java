package com.mrwang.d_aspect.b_anno;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("d_aspect.b_anno addUser");
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		int i = 1 / 0;
		System.out.println("d_aspect.b_anno updateUser");
	}

	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("d_aspect.b_anno deleteUser");
		return "油~";
	}

}
