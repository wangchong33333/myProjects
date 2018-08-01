package com.mrwang.helloms.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mrwang.helloms.po.Items;
import com.mrwang.helloms.po.ItemsExample;
import com.mrwang.helloms.po.ItemsExample.Criteria;

public class ItemsMapperTest {
	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"config/spring/applicationContext.xml");
	}

	@Test
	public void testSelectByExample() {
		ItemsMapper iMapper = (ItemsMapper) ctx.getBean("itemsMapper");
		ItemsExample example = new ItemsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%背包%");
		List<Items> list = iMapper.selectByExample(example);
		System.out.println(list);
	}

}
