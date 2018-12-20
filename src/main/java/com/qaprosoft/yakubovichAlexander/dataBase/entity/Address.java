package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Address extends Id{

	private String street;
	private int numberHome;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumberHome() {
		return numberHome;
	}
	public void setNumberHome(int numberHome) {
		this.numberHome = numberHome;
	}
	
	@Override 
	public String toString() {
		return super.toString() + "; Street = " + this.street + "; Number home = " + this.numberHome;
	}
	
}
