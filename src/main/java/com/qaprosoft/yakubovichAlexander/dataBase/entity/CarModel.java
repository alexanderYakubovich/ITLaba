package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class CarModel extends Id{
	
	private String color;
	private String model;
	private String number;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return super.toString() + "; Color = " + this.color + "; Model = " + this.model + "; Number car = " + this.number;
	}
	
}
