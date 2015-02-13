package com.infrastructure.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infrastructure.dao.SimpleEntityDao;
import com.infrastructure.model.SimpleEntity;
import com.infrastructure.service.SimpleEntityService;

public abstract class SimpleEntityServiceImpl<PKType extends Number, EntityType extends SimpleEntity<PKType>, IDaoType extends SimpleEntityDao<PKType, EntityType>> 
	extends EntityServiceImpl<PKType, EntityType, IDaoType> implements SimpleEntityService<PKType, EntityType, IDaoType> { 
	
	public SimpleEntityServiceImpl(IDaoType dao){
		super(dao);
	}
	
	@Override
	public Map<PKType, String> getSelectSource(){
		Map<PKType,String> ret=new HashMap<PKType,String>();
		List<EntityType> entities=entityDao.listAll();
		for(EntityType entity : entities){
			ret.put(entity.getId(), entity.getName());
		}
		return ret;
	} 
}
