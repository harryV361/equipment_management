package com.infrastructure.dao.impl;

import com.infrastructure.dao.SimpleEntityDao;
import com.infrastructure.model.SimpleEntity;

public abstract class SimpleEntityDaoImpl<PKType extends Number, EntityType extends SimpleEntity<PKType>> 
	extends EntityDaoImpl<PKType, EntityType> implements SimpleEntityDao<PKType, EntityType> {

}
