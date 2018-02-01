package com.mrwang.sso.service;

import com.mrwang.common.utils.E3Result;
import com.mrwang.pojo.TbUser;

public interface TokenService {

	E3Result getUserByToken(String token);
}
