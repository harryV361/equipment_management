package com.management.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.extension.StringHelper;
import com.infrastructure.service.impl.EnableEntityServiceImpl;
import com.infrastructure.util.PageList;
import com.infrastructure.util.PageListUtil;
import com.management.dao.AccountDao;
import com.management.model.Account;
import com.management.model.Organization;
import com.management.model.Role;
import com.management.service.AccountService;
import com.management.service.OrganizationService;
import com.management.service.RoleService;

@Service("AccountService")
public class AccountServiceImpl extends EnableEntityServiceImpl<Integer, Account, AccountDao> implements AccountService {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("AuthorityService") protected IAuthorityService
	 * authorityService;
	 */
	@Autowired
	@Qualifier("RoleService")
	protected RoleService roleService;

	@Autowired
	@Qualifier("OrganizationService")
	protected OrganizationService organizationService;

	@Autowired
	public AccountServiceImpl(@Qualifier("AccountDao") AccountDao accountDao) {
		super(accountDao);
	}

	@Override
	@SuppressWarnings("unchecked")
	public PageList<Account> listPage(String name, String username, int pageNo, int pageSize) {
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();

		if (name != null && !name.isEmpty()) {
			countCriteria.add(Restrictions.eq("name", name));
			listCriteria.add(Restrictions.eq("name", name));
		}
		if (username != null && !username.isEmpty()) {
			countCriteria.add(Restrictions.eq("username", username));
			listCriteria.add(Restrictions.eq("username", username));
		}

		listCriteria.setFirstResult((pageNo - 1) * pageSize);
		listCriteria.setMaxResults(pageSize);
		List<Account> items = listCriteria.list();
		countCriteria.setProjection(Projections.rowCount());
		Integer count = Integer.parseInt(countCriteria.uniqueResult().toString());

		return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}

	@Override
	public boolean accountExist(String username) {
		Criteria criteria = entityDao.getCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.setProjection(Projections.rowCount());

		Integer count = Integer.parseInt(criteria.uniqueResult().toString());
		if (count != null && count > 0)
			return true;
		else
			return false;

	}

	@Override
	public void saveRegister(Account account) throws EntityOperateException, ValidatException, NoSuchAlgorithmException {
		account.setPassword(StringHelper.md5(account.getUsername() + account.getPassword()));
		account.setRegisterTime(Calendar.getInstance());
		super.save(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account login(String username, String password) throws NoSuchAlgorithmException {
		Criteria criteria = entityDao.getCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", StringHelper.md5(username + password)));
		List<Account> accounts = criteria.list();

		Account ret = null;
		if (accounts != null && !accounts.isEmpty())
			ret = accounts.get(0);

		return ret;
	}

	@Override
	public void updateBind(Integer id, Integer roleId, Integer organizationId) throws ValidatException, EntityOperateException {
		Account dbAccount = super.get(id);
		if (roleId != null && roleId > 0) {
			Role dbRole = roleService.get(roleId);
			dbAccount.setRole(dbRole);
		} else
			dbAccount.setRole(null);
		if (organizationId != null && organizationId > 0) {
			Organization dbOrganization = organizationService.get(organizationId);
			dbAccount.setOrganization(dbOrganization);
		} else
			dbAccount.setOrganization(null);
		super.update(dbAccount);
	}

	@Override
	public void updateVilidataCode(Integer id, String vilidataCode, Timestamp expires) throws ValidatException, EntityOperateException {
		Account dbAccount = super.get(id);

		if (dbAccount != null) {
			dbAccount.setVilidataCode(vilidataCode);
			dbAccount.setExpires(expires);
			super.update(dbAccount);
		}

	}

}
