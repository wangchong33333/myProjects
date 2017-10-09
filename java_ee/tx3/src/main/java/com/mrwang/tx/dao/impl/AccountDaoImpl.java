package com.mrwang.tx.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mrwang.tx.dao.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void out(String outer, Integer money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				"update account set money=money-? where username=?", money,
				outer);
	}

	@Override
	public void in(String inner, Integer money) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(
				"update account set money=money+? where username=?", money,
				inner);
	}

}
