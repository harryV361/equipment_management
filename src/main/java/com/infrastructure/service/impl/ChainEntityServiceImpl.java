package com.infrastructure.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.infrastructure.dao.ChainEntityDao;
import com.infrastructure.model.ChainEntity;
import com.infrastructure.service.ChainEntityService;

public abstract class ChainEntityServiceImpl<PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>, IDaoType extends ChainEntityDao<PKType, EntityType>>
	extends EnableEntityServiceImpl<PKType, EntityType, IDaoType> implements ChainEntityService<PKType, EntityType, IDaoType>{ 
	
	public ChainEntityServiceImpl(IDaoType dao){
		super(dao);
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityType> listChain(){
		return entityDao.getCriteria().add(Restrictions.isNull("parent")).list();
	}

}
