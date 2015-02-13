package com.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.infrastructure.dao.EnableEntityDao;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.model.EnableEntity;

public interface EnableEntityService<PKType extends Number, EntityType extends EnableEntity<PKType>, IDaoType extends EnableEntityDao<PKType, EntityType>> extends SimpleEntityService<PKType, EntityType, IDaoType> {
	
	public List<EntityType> listEnable();
	public List<EntityType> listDisable();
	public void enable(EntityType model) throws EntityOperateException, ValidatException;
	public void disable(EntityType model) throws EntityOperateException, ValidatException;
	public Map<PKType, String> getEnableSelectSource();
	
}
