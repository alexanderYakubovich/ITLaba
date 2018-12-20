package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public abstract class Id {
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n" + "Id = " + this.id  ;
	}
}
