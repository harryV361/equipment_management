package com.infrastructure.service;

import java.util.Map;

import com.infrastructure.dao.SimpleEntityDao;
import com.infrastructure.model.SimpleEntity;

public interface SimpleEntityService<PKType extends Number, EntityType extends SimpleEntity<PKType>, IDaoType extends SimpleEntityDao<PKType, EntityType>> extends EntityService<PKType, EntityType, IDaoType> {
    public Map<PKType, String> getSelectSource();
}
