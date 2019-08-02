package com.service.ship.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.service.ship.entity.base.BaseModel;

@Entity
@Table
public class Role extends BaseModel {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
