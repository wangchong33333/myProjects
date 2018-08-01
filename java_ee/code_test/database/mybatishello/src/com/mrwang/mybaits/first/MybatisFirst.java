package com.mrwang.mybaits.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mrwang.mybaits.po.User;

public class MybatisFirst {

	@Test
	public void findUserByIdTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

		sqlSession.close();

	}

	@Test
	public void findUserByNameTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUsersByName", "Ð¡Ã÷");
		System.out.println(list);

		sqlSession.close();

	}

	@Test
	public void insertUserTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setUsername("ÓÍ~");
		user.setAddress("Îäºº");
		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();
		
		sqlSession.close();

	}
}
