package com.management.model.extension;

import com.management.model.Account;
import com.management.model.AccountAuthorizeModel;

public class AccountAuthorizeModelExtension {

	public static AccountAuthorizeModel toAccountBindModel(Account account) {
		AccountAuthorizeModel ret = new AccountAuthorizeModel();
		ret.setName(account.getName());
		ret.setUsername(account.getUsername());
		if (account.getRole() != null)
			ret.setRoleId(account.getRole().getId());
		if (account.getOrganization() != null)
			ret.setOrganizationId(account.getOrganization().getId());

		return ret;
	}

}
