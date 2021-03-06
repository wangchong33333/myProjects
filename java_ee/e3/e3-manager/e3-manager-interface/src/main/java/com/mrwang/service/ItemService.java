package com.mrwang.service;

import com.mrwang.common.pojo.EasyUIDataGridResult;
import com.mrwang.common.utils.E3Result;
import com.mrwang.pojo.TbItem;
import com.mrwang.pojo.TbItemDesc;

public interface ItemService {
	TbItem getItemById(long itemId);

	EasyUIDataGridResult getItemList(int page, int rows);

	E3Result addItem(TbItem item, String desc);

	TbItemDesc getItemDescById(long itemId);
}
