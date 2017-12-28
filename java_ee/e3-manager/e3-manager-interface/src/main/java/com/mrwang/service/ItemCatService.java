package com.mrwang.service;

import java.util.List;

import com.mrwang.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
