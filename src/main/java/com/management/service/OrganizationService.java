package com.management.service;

import com.infrastructure.service.ChainEntityService;
import com.infrastructure.util.PageList;
import com.management.dao.OrganizationDao;
import com.management.model.Organization;

public interface OrganizationService extends
		ChainEntityService<Integer, Organization, OrganizationDao> {

	public PageList<Organization> listPage(String name, int pageNo, int pageSize);

}