package com.mrwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrwang.common.pojo.EasyUIDataGridResult;
import com.mrwang.mapper.TbItemMapper;
import com.mrwang.pojo.TbItem;
import com.mrwang.pojo.TbItemExample;
import com.mrwang.pojo.TbItemExample.Criteria;
import com.mrwang.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	public TbItem geItemById(long itemId) {
		// TbItem item = itemMapper.selectByPrimaryKey(itemId);

		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

}
