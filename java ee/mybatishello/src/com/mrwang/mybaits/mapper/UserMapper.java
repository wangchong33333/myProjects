package com.mrwang.mybaits.mapper;

import java.util.List;

import com.mrwang.mybaits.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;

	public void insertUser(User user) throws Exception;
	
}
