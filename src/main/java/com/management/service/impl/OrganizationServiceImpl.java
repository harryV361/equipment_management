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
import com.management.dao.OrganizationDao;
import com.management.model.Organization;
import com.management.service.OrganizationService;

@Service("OrganizationService")
public class OrganizationServiceImpl extends
		ChainEntityServiceImpl<Integer, Organization, OrganizationDao> implements
		OrganizationService {

	@Autowired
	public OrganizationServiceImpl(
			@Qualifier("OrganizationDao") OrganizationDao organizationDao) {
		super(organizationDao);
	}

	@Override
	public void update(Organization model) throws ValidatException,
			EntityOperateException {
		Organization dbModel = super.get(model.getId());
		dbModel.setName(model.getName());
		dbModel.setPosition(model.getPosition());
		dbModel.setTheValue(model.getTheValue());
		dbModel.setParent(model.getParent());
		super.update(dbModel);
	}

	@Override
	@SuppressWarnings("unchecked")
	public PageList<Organization> listPage(String name, int pageNo, int pageSize) {
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();

		if (name != null && !name.isEmpty()) {
			countCriteria.add(Restrictions.eq("name", name));
			listCriteria.add(Restrictions.eq("name", name));
		}

		listCriteria.setFirstResult((pageNo - 1) * pageSize);
		listCriteria.setMaxResults(pageSize);
		List<Organization> items = listCriteria.list();
		countCriteria.setProjection(Projections.rowCount());
		Integer count = Integer.parseInt(countCriteria.uniqueResult()
				.toString());
		return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}

}
