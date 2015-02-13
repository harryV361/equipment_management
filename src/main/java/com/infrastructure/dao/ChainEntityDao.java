package com.infrastructure.dao;

import com.infrastructure.model.ChainEntity;

public interface ChainEntityDao<PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>> extends EnableEntityDao<PKType, EntityType> {
	
}
