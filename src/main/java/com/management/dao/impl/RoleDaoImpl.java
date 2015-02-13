package com.management.dao.impl;

import org.springframework.stereotype.Repository;

import com.infrastructure.dao.impl.EnableEntityDaoImpl;
import com.management.dao.RoleDao;
import com.management.model.Role;

@Repository("RoleDao")
public class RoleDaoImpl extends EnableEntityDaoImpl<Integer, Role> implements RoleDao {

}
