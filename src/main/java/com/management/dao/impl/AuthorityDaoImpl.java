package com.management.dao.impl;

import org.springframework.stereotype.Repository;

import com.infrastructure.dao.impl.ChainEntityDaoImpl;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.management.dao.AuthorityDao;
import com.management.model.Authority;

@Repository("AuthorityDao")
public class AuthorityDaoImpl extends ChainEntityDaoImpl<Integer, Authority> implements
		AuthorityDao {

	@Override
	public void delete(Authority authority) throws EntityOperateException,
			ValidatException {
		super.checkNull(authority);
		super.checkUpdatable(authority);
		if (authority.getChildren() != null
				&& !authority.getChildren().isEmpty())
			throw new ValidatException(
					"The entity has children can't be delete!");
		else if (authority.getRoles() != null
				&& !authority.getRoles().isEmpty())
			throw new ValidatException(
					"the entity had been authorized can't be delete!");
		else
			super.getSession().delete(authority);
	}

}
