package com.infrastructure.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infrastructure.dao.EnableEntityDao;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;
import com.infrastructure.model.EnableEntity;
import com.infrastructure.service.EnableEntityService;

public abstract class EnableEntityServiceImpl<PKType extends Number, EntityType extends EnableEntity<PKType>, IDaoType extends EnableEntityDao<PKType, EntityType>> 
	extends SimpleEntityServiceImpl<PKType, EntityType, IDaoType> implements EnableEntityService<PKType, EntityType, IDaoType> { 
	
	public EnableEntityServiceImpl(IDaoType dao){
		super(dao);
	}
	
	@Override
	public List<EntityType> listEnable() {
		return entityDao.listEnable();
	}
	
	@Override
	public List<EntityType> listDisable() {
		return entityDao.listDisable();
	}
	
	@Override
	public void enable(EntityType model) throws EntityOperateException, ValidatException  {
	    entityDao.enable(model);
	}
	
	@Override
	public void disable(EntityType model) throws EntityOperateException, ValidatException  {
	    entityDao.disable(model);
	}
	
	@Override
	public Map<PKType, String> getEnableSelectSource(){
		Map<PKType, String> ret=new HashMap<PKType, String>();
		List<EntityType> entities=listEnable();
		for(EntityType entity : entities){
			ret.put(entity.getId(), entity.getName());
		}
		return ret;
	}

}
