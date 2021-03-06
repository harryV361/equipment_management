package com.management.model.extension;

import com.management.model.Role;
import com.management.model.RoleEditModel;
import com.management.model.RoleSearch;
import com.management.model.RoleSearchModel;

public class RoleModelExtension {
	public static RoleSearch toRoleSearch(RoleSearchModel searchModel) {
		RoleSearch ret = new RoleSearch();
		ret.setName(searchModel.getName());

		return ret;
	}

	public static Role toRole(RoleEditModel editModel) {
		Role role = new Role();
		role.setId(editModel.getId());
		role.setName(editModel.getName());
		return role;
	}
}
