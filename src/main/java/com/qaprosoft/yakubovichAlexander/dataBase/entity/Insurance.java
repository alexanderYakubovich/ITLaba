package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Insurance extends Id{

	private int validity;
	private String city;
	private int drivingExperience;
	private long driverId;

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDrivingExpirience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}
	

	@Override
	public String toString() {
		return super.toString() + "; Driver ID = " + this.driverId + "; City = " + this.city + "; Driving experiance = " + this.drivingExperience
				+ "; Validity = " + this.validity;
	}

	
}
