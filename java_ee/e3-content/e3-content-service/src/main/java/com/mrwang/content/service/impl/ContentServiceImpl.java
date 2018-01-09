package com.mrwang.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrwang.common.utils.E3Result;
import com.mrwang.content.service.ContentService;
import com.mrwang.mapper.TbContentMapper;
import com.mrwang.pojo.TbContent;
import com.mrwang.pojo.TbContentExample;
import com.mrwang.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	TbContentMapper contentMapper;

	@Override
	public E3Result addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		return E3Result.ok();
	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		TbContentExample example=new TbContentExample();
		Criteria criteria= example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		return list;
	}

}
