package com.mrwang.sso.service;

import com.mrwang.common.utils.E3Result;

public interface RegisterService {
	E3Result checkData(String param, int type);
}
