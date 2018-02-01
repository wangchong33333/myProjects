package com.mrwang.sso.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.mrwang.common.jedis.JedisClient;
import com.mrwang.common.utils.E3Result;
import com.mrwang.common.utils.JsonUtils;
import com.mrwang.mapper.TbUserMapper;
import com.mrwang.pojo.TbUser;
import com.mrwang.pojo.TbUserExample;
import com.mrwang.pojo.TbUserExample.Criteria;
import com.mrwang.sso.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public E3Result userLogin(String name, String password) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(name);
		List<TbUser> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return E3Result.build(400, "用户名或密码错误");
		}
		TbUser user = list.get(0);
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return E3Result.build(400, "用户名或密码错误");
		}
		String token = UUID.randomUUID().toString();
		user.setPassword(null);
		jedisClient.set("SESSION:" + token, JsonUtils.objectToJson(user));
		jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
		return E3Result.ok(token);
	}

}
