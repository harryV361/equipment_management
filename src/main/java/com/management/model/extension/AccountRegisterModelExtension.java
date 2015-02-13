package com.management.model.extension;

import com.management.model.Account;
import com.management.model.AccountRegisterModel;

public class AccountRegisterModelExtension {
	public static Account toAccount(AccountRegisterModel registerModel) {
		Account ret = new Account();
		ret.setName(registerModel.getName());
		ret.setEmail(registerModel.getEmail());
		ret.setUsername(registerModel.getUsername());
		ret.setPassword(registerModel.getPassword());

		return ret;
	}
}
