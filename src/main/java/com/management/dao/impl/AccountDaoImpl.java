package com.management.dao.impl;

import org.springframework.stereotype.Repository;

import com.infrastructure.dao.impl.EnableEntityDaoImpl;
import com.management.dao.AccountDao;
import com.management.model.Account;

@Repository("AccountDao")
public class AccountDaoImpl extends EnableEntityDaoImpl<Integer, Account> implements
		AccountDao {

}
