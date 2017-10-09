package com.mrwang.tx.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.mrwang.tx.dao.AccountDao;
import com.mrwang.tx.service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;
	private TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(final String outer, final String inner,
			final Integer money) {
		// TODO Auto-generated method stub
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				accountDao.out(outer, money);
				int i = 1 / 0;
				accountDao.in(inner, money);
			}
		});
	}

}
