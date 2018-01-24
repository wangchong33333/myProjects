package com.mrwang.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrwang.common.utils.E3Result;
import com.mrwang.mapper.TbUserMapper;
import com.mrwang.pojo.TbUser;
import com.mrwang.pojo.TbUserExample;
import com.mrwang.pojo.TbUserExample.Criteria;
import com.mrwang.sso.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	TbUserMapper userMapper;

	@Override
	public E3Result checkData(String param, int type) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		if (type == 1) {
			criteria.andUsernameEqualTo(param);
		} else if (type == 2) {
			criteria.andPhoneEqualTo(param);
		} else if (type == 3) {
			criteria.andEmailEqualTo(param);
		} else {
			return E3Result.build(400, "数据类型错误");
		}

		List<TbUser> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return E3Result.ok(false);
		}

		return E3Result.ok(true);
	}

}
