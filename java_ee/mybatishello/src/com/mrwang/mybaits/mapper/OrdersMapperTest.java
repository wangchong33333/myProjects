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

import com.mrwang.mybaits.po.OrdersExt;

public class OrdersMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersAndUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndUser();
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndUserRstMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndUserRstMap();
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndDetailRstMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndDetailRstMap();
		sqlSession.close();
	}
}
