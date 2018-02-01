package com.mrwang.sso.service;

import com.mrwang.common.utils.E3Result;

public interface LoginService {
	E3Result userLogin(String name, String password);

}
