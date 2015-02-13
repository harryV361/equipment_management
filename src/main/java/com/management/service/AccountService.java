package com.management.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.service.EnableEntityService;
import com.infrastructure.util.PageList;
import com.management.dao.AccountDao;
import com.management.model.Account;

public interface AccountService extends EnableEntityService<Integer, Account, AccountDao> {

	public PageList<Account> listPage(String name, String username, int pageNo, int pageSize);

	public boolean accountExist(String username);

	public Account login(String username, String password) throws NoSuchAlgorithmException;

	public void saveRegister(Account account) throws NoSuchAlgorithmException, EntityOperateException, ValidatException;

	public void updateBind(Integer id, Integer roleId, Integer organizationId) throws ValidatException, EntityOperateException;

	public void updateVilidataCode(Integer id, String vilidataCode, Timestamp expires) throws ValidatException, EntityOperateException;

}