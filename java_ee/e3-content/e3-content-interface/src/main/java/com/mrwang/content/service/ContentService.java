package com.mrwang.content.service;

import java.util.List;

import com.mrwang.common.utils.E3Result;
import com.mrwang.pojo.TbContent;

public interface ContentService {
	E3Result addContent(TbContent content);
	List<TbContent> getContentListByCid(long cid);
}
