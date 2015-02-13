package com.management.model.extension;

import com.management.model.Role;
import com.management.model.RoleBindModel;

public class RoleBindModelExtension {

	public static RoleBindModel toRoleBindModel(Role role) {
		RoleBindModel ret = new RoleBindModel();
		ret.setName(role.getName());

		return ret;
	}

}
