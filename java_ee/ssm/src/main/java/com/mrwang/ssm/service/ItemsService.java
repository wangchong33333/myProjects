package com.mrwang.ssm.service;

import java.util.List;

import com.mrwang.ssm.domain.Items;

public interface ItemsService {

	List<Items> findAll();

	Items findByID(Integer id);

	void saveOrUpdate(Items items);

}
