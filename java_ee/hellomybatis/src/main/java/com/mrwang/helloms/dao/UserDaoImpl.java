package com.mrwang.helloms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mrwang.helloms.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) throws Exception {
		User user = getSqlSession().selectOne("test.findUserById", id);
		return user;
	}

	// @Override
	// public List<User> findUsersByName(String name) {
	// SqlSession sqlSession = sqlSessionFactory.openSession();
	//
	// List<User> list = sqlSession.selectList("test.findUsersByName", name);
	// System.out.println(list);
	//
	// sqlSession.close();
	// return list;
	// }
	//
	// @Override
	// public void insertUser(User user) {
	// SqlSession sqlSession = sqlSessionFactory.openSession();
	//
	// sqlSession.insert("test.insertUser", user);
	//
	// sqlSession.commit();
	//
	// sqlSession.close();
	//
	// }

}
