package com.qaprosoft.yakubovichAlexander.dataBase.entity;

import java.util.List;

public class Car extends Id {

	private long carModelId;
	private long driverId;
	private CarModel carModel;
	private List<Service> serviceList;

	public long getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(long carModelId) {
		this.carModelId = carModelId;
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "Car [carModelId=" + carModelId + ", driverId=" + driverId + ", carModel=" + carModel + ", serviceList="
				+ serviceList  + super.toString() + "]";
	}

}
