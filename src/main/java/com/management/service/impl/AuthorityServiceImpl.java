package com.management.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.service.impl.ChainEntityServiceImpl;
import com.infrastructure.util.PageList;
import com.infrastructure.util.PageListUtil;
import com.management.dao.AuthorityDao;
import com.management.model.Authority;
import com.management.model.AuthoritySearch;
import com.management.service.AuthorityService;

@Service("AuthorityService")
public class AuthorityServiceImpl extends
		ChainEntityServiceImpl<Integer, Authority, AuthorityDao> implements
		AuthorityService {

	@Autowired
	public AuthorityServiceImpl(
			@Qualifier("AuthorityDao") AuthorityDao authorityDao) {
		super(authorityDao);
	}

	@Override
	public void update(Authority model) throws ValidatException,
			EntityOperateException {
		Authority dbModel = super.get(model.getId());
		dbModel.setName(model.getName());
		dbModel.setPosition(model.getPosition());
		dbModel.setTheValue(model.getTheValue());
		dbModel.setUrl(model.getUrl());
		dbModel.setMatchUrl(model.getMatchUrl());
		dbModel.setItemIcon(model.getItemIcon());
		dbModel.setParent(model.getParent());
		super.update(dbModel);
	}

	@Override
	@SuppressWarnings("unchecked")
	public PageList<Authority> listPage(AuthoritySearch search, int pageNo,
			int pageSize) {
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();

		if (search != null) {
			if (search.getName() != null && !search.getName().isEmpty()) {
				countCriteria.add(Restrictions.eq("name", search.getName()));
				listCriteria.add(Restrictions.eq("name", search.getName()));
			}
		}

		listCriteria.setFirstResult((pageNo - 1) * pageSize);
		listCriteria.setMaxResults(pageSize);
		List<Authority> items = listCriteria.list();
		countCriteria.setProjection(Projections.rowCount());
		Integer count = Integer.parseInt(countCriteria.uniqueResult()
				.toString());
		return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}

}
