package com.management.model;

import java.util.List;
import com.infrastructure.model.ICUDEable;
import com.infrastructure.model.EnableEntity;

public class Role extends EnableEntity<Integer> implements ICUDEable {

	private List<Authority> authorities;

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<Authority> getAuthorities() {
		return this.authorities;
	}

}
