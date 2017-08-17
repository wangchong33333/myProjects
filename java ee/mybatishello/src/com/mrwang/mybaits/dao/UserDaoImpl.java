package com.mrwang.mybaits.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mrwang.mybaits.po.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = sqlSession.selectOne("test.findUserById", id);
		System.out.println(user);

		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUsersByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUsersByName", name);
		System.out.println(list);

		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();

		sqlSession.close();

	}

}
