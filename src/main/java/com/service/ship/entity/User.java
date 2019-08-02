package com.service.ship.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.service.ship.entity.base.BaseModel;

@Entity
@Table
public class User extends BaseModel {

	private String username;

	private String displayName;

	private String password;

	private boolean enabled;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
