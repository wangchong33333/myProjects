package com.mrwang.mybaits.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mrwang.mybaits.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;

	public List<User> findUsersByName(String name) throws Exception;

	public void insertUser(User user) throws Exception;
}
