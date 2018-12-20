package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Route extends Id{

	private int distance;
	private int time;
	private long orderId;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return super.toString() + "; Distance = " + this.distance + "; Time = " + this.time + "; Order Id = " +this.orderId;
	}

	
}
