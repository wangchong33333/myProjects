package com.mrwang.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.SubnetUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrwang.common.jedis.JedisClient;
import com.mrwang.common.utils.E3Result;
import com.mrwang.common.utils.JsonUtils;
import com.mrwang.content.service.ContentService;
import com.mrwang.mapper.TbContentMapper;
import com.mrwang.pojo.TbContent;
import com.mrwang.pojo.TbContentExample;
import com.mrwang.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;

	@Value("${CONTENT_LIST}")
	private String CONTENT_LIST;

	@Override
	public E3Result addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		// 缓存同步
		jedisClient.hdel(CONTENT_LIST, content.getCategoryId().toString());
		return E3Result.ok();
	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		try {
			String json = jedisClient.hget(CONTENT_LIST, cid + "");
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);

		try {
			jedisClient.hset(CONTENT_LIST, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
