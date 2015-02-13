package com.infrastructure.dao;

import com.infrastructure.model.SimpleEntity;

public interface SimpleEntityDao<PKType extends Number, EntityType extends SimpleEntity<PKType>> extends EntityDao<PKType, EntityType> {
	
}
