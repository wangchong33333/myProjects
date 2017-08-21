package com.mrwang.mybaits.mapper;

import java.util.List;

import com.mrwang.mybaits.po.User;
import com.mrwang.mybaits.po.UserQueryVO;

public interface UserMapper {
	public User findUserById(int id) throws Exception;

	public void insertUser(User user) throws Exception;

	public List<User> findUserList(UserQueryVO vo);

}
