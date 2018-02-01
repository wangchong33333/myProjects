package com.mrwang.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrwang.common.jedis.JedisClient;
import com.mrwang.common.utils.E3Result;
import com.mrwang.common.utils.JsonUtils;
import com.mrwang.pojo.TbUser;
import com.mrwang.sso.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
	@Autowired
	private JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public E3Result getUserByToken(String token) {
		String json = jedisClient.get("SESSION:" + token);
		if (StringUtils.isBlank(json)) {
			return E3Result.build(201, "用户登录已经过期");
		}
		jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		return E3Result.ok(user);
	}

}
