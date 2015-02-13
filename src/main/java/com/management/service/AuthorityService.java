package com.management.service;

import com.infrastructure.service.ChainEntityService;
import com.infrastructure.util.PageList;
import com.management.dao.AuthorityDao;
import com.management.model.Authority;
import com.management.model.AuthoritySearch;

public interface AuthorityService extends
		ChainEntityService<Integer, Authority, AuthorityDao> {

	public PageList<Authority> listPage(AuthoritySearch search, int pageNo,
			int pageSize);

}