package com.infrastructure.dao;

import java.util.List;
import com.infrastructure.model.EnableEntity;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;

public interface EnableEntityDao<PKType extends Number, EntityType extends EnableEntity<PKType>> extends SimpleEntityDao<PKType, EntityType> {
	
	public List<EntityType> listEnable();
	public List<EntityType> listDisable();
	public void enable(EntityType entity) throws EntityOperateException, ValidatException;
	public void disable(EntityType entity) throws EntityOperateException, ValidatException;
	
}
