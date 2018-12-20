package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Service extends Id {

	private String nameStation;
	private int numberCars;

	public String getNameStation() {
		return nameStation;
	}

	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
	}

	public int getNumberCars() {
		return numberCars;
	}

	public void setNumberCars(int numberCars) {
		this.numberCars = numberCars;
	}

	@Override
	public String toString() {
		return super.toString() + "; Name station = " + this.nameStation + "; Number cars = " + this.numberCars;
	}

}
