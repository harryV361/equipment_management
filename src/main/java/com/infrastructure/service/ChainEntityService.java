package com.infrastructure.service;

import java.util.List;

import com.infrastructure.dao.ChainEntityDao;
import com.infrastructure.model.ChainEntity;

public interface ChainEntityService<PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>, IDaoType extends ChainEntityDao<PKType, EntityType>> extends EnableEntityService<PKType, EntityType, IDaoType> {
	
	public List<EntityType> listChain();
	
}
