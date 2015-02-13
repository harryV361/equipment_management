package com.management.dao.impl;

import org.springframework.stereotype.Repository;

import com.infrastructure.dao.impl.ChainEntityDaoImpl;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.management.dao.OrganizationDao;
import com.management.model.Organization;

@Repository("OrganizationDao")
public class OrganizationDaoImpl extends ChainEntityDaoImpl<Integer, Organization>
		implements OrganizationDao {

	@Override
	public void delete(Organization organization)
			throws EntityOperateException, ValidatException {
		super.checkNull(organization);
		super.checkUpdatable(organization);
		if (organization.getChildren() != null
				&& !organization.getChildren().isEmpty())
			throw new ValidatException(
					"The entity has children can't be delete!");
		else
			super.getSession().delete(organization);
	}

}
