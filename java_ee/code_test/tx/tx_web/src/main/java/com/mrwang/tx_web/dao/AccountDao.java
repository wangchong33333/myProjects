package com.mrwang.tx_web.dao;

public interface AccountDao {
	public void out(String outer, Integer money);

	public void in(String inner, Integer money);

}
