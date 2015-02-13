package com.management.model;

import java.sql.Timestamp;
import java.util.Calendar;

import com.infrastructure.model.ICUDEable;
import com.infrastructure.model.EnableEntity;

public class Account extends EnableEntity<Integer> implements ICUDEable {

	private String email;
	private String username;
	private String password;
	private Calendar registerTime;
	private Role role;
	private Organization organization;
	private String vilidataCode;
	private Timestamp expires;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegisterTime(Calendar registerTime) {
		this.registerTime = registerTime;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public Calendar getRegisterTime() {
		return this.registerTime;
	}

	public Role getRole() {
		return this.role;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public String getVilidataCode() {
		return vilidataCode;
	}

	public void setVilidataCode(String vilidataCode) {
		this.vilidataCode = vilidataCode;
	}

	public Timestamp getExpires() {
		return expires;
	}

	public void setExpires(Timestamp expires) {
		this.expires = expires;
	}

}
