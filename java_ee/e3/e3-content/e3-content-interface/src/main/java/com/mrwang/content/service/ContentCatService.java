package com.mrwang.content.service;

import java.util.List;

import com.mrwang.common.pojo.EasyUITreeNode;
import com.mrwang.common.utils.E3Result;

public interface ContentCatService {
	List<EasyUITreeNode> getCosntentCatList(long parentId);
	E3Result addContentCat(long parentId,String name);
}
