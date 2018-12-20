package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Client extends User {

	private long userClId;

	public long getUserClId() {
		return userClId;
	}

	public void setUserClId(long userClId) {
		this.userClId = userClId;
	}

	

	@Override
	public String toString() {
		return super.toString() + "; Id client = " + this.userClId;
	}

}
