package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Driver extends User {

	private long userId;
	private DriverLicense driverLicense;
	private InspectionCertificate inspectionCertificate;
	private Insurance insurance;
	private Car car;
	private MedicalSertificate medicalSertificate;


	public InspectionCertificate getInspectionCertificate() {
		return inspectionCertificate;
	}

	public void setInspectionCertificate(InspectionCertificate inspectionCertificate) {
		this.inspectionCertificate = inspectionCertificate;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public MedicalSertificate getMedicalSertificate() {
		return medicalSertificate;
	}

	public void setMedicalSertificate(MedicalSertificate medicalSertificate) {
		this.medicalSertificate = medicalSertificate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
	}
	@Override
	public String toString() {
		return super.toString() + "; User ID = " + this.userId + ";" + "\n" + "Driver license: " + this.driverLicense + "\n" +
				"Inspection Sertificate: " + this.inspectionCertificate + "\n" +"Insurance: " + this.insurance + 
				"\n" +"Medical sertificate: " + this.medicalSertificate; 
	}
}
