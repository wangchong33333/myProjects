package com.mrwang.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrwang.common.pojo.EasyUITreeNode;
import com.mrwang.common.utils.E3Result;
import com.mrwang.content.service.ContentCatService;
import com.mrwang.mapper.TbContentCategoryMapper;
import com.mrwang.pojo.TbContentCategory;
import com.mrwang.pojo.TbContentCategoryExample;
import com.mrwang.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentCatServiceImpl implements ContentCatService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getCosntentCatList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catList = contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> nodes = new ArrayList<>();
		for (TbContentCategory category : catList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent() ? "closed" : "open");
			nodes.add(node);
		}

		return nodes;
	}

	@Override
	public E3Result addContentCat(long parentId, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		// 1(正常),2(删除)
		category.setStatus(1);
		category.setSortOrder(1);
		category.setIsParent(false);
		category.setCreated(new Date());
		category.setUpdated(new Date());

		contentCategoryMapper.insert(category);
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parent.getIsParent()) {
			parent.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		return E3Result.ok(category);
	}

}
