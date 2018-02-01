package com.mrwang.sso.service;

import com.mrwang.common.utils.E3Result;
import com.mrwang.pojo.TbUser;

public interface RegisterService {
	E3Result checkData(String param, int type);
	E3Result register(TbUser user);
}
