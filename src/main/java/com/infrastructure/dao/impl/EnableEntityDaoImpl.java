package com.infrastructure.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.infrastructure.dao.EnableEntityDao;
import com.infrastructure.model.IEnableable;
import com.infrastructure.model.EnableEntity;
import com.infrastructure.exception.EntityOperateException;
import com.infrastructure.exception.ValidatException;

public abstract class EnableEntityDaoImpl<PKType extends Number, EntityType extends EnableEntity<PKType>>
	extends SimpleEntityDaoImpl<PKType, EntityType> implements EnableEntityDao<PKType, EntityType> {

	@Override
	@SuppressWarnings("unchecked")
	public List<EntityType> listEnable() {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("enable", true)); 
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<EntityType> listDisable() {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("enable", false)); 
		return criteria.list();
	}	
	
	@Override
	public void enable(EntityType entity) throws EntityOperateException, ValidatException{
		if(entity==null)
			throw new NullPointerException("entity is null!");
		else if(!(entity instanceof IEnableable))
			throw new EntityOperateException("the entity not support IEnableable throw by enable!");
		entity.setEnable(true);
		update(entity);
	}
	
	@Override
	public void disable(EntityType entity) throws EntityOperateException, ValidatException{
		if(entity==null)
			throw new NullPointerException("entity is null!");
		else if(!(entity instanceof IEnableable))
			throw new EntityOperateException("the entity not support IEnableable throw by disable!");
		entity.setEnable(false);
		update(entity);
	}	
}