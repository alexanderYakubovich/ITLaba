package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Payment extends Id{

	private String type;
	private long orderId;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() + "; Type payment = " + this.type + "; Order Id = " + this.orderId;
	}

	
}
