package com.mrwang.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrwang.ssm.dao.ItemsMapper;
import com.mrwang.ssm.domain.Items;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Resource
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> findAll() {
		// TODO Auto-generated method stub
		List<Items> list= itemsMapper.findAll();
		return list;
	}

	@Override
	public Items findByID(Integer id) {
		// TODO Auto-generated method stub
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void saveOrUpdate(Items items) {
		// TODO Auto-generated method stub
		itemsMapper.updateByPrimaryKey(items);
	}

}
