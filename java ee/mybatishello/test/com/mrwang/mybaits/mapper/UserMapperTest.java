package com.mrwang.mybaits.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mrwang.mybaits.po.User;
import com.mrwang.mybaits.po.UserQueryVO;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user=new User();
		user.setUsername("ºÙºÙºÙ");
		user.setAddress("±»½û");
		mapper.insertUser(user);
		System.out.println(user.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVO vo=new UserQueryVO();
		User user=new User();
		user.setUsername("Ð¡Ã÷");
		user.setSex("1");
		vo.setUser(user);
		List<User> users = mapper.findUserList(vo);
		
		System.out.println(users);
		sqlSession.close();
	}

}
