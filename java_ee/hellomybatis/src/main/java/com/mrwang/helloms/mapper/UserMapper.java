package com.mrwang.helloms.mapper;

import java.util.List;

import com.mrwang.helloms.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;
}
