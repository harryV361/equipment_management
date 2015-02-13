package com.management.service;

import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.service.EnableEntityService;
import com.infrastructure.util.PageList;
import com.management.dao.RoleDao;
import com.management.model.Role;
import com.management.model.RoleSearch;

public interface RoleService extends
		EnableEntityService<Integer, Role, RoleDao> {

	public PageList<Role> listPage(RoleSearch search, int pageNo, int pageSize);

	public void saveAuthorize(Integer roleId, Integer[] authorityIds)
			throws ValidatException, EntityOperateException;

}