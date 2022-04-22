package com.ori98.jpawebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// this is the object that we will be using to fetch info and persist in DB

@Entity
@Table(name="avenger_table")
public class Avenger {
	
	private int aId;
	private String aName;
	private String aPower;	
	
	@Id
	@Column(name = "avenger_id")
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	
	@Column(name = "avenger_name")
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	
	@Column(name = "avenger_power")
	public String getaPower() {
		return aPower;
	}
	public void setaPower(String aPower) {
		this.aPower = aPower;
	}
	@Override
	public String toString() {
		return "Avenger [aId=" + aId + ", aName=" + aName + ", aPower=" + aPower + "]";
	}
}
