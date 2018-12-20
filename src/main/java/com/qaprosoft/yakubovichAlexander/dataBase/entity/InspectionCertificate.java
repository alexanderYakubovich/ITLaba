package com.qaprosoft.yakubovichAlexander.dataBase.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InspectionCertificate extends Id{

	private Date expDate;
	private long driverId;

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public String getExDate() {
		String sDate = new SimpleDateFormat("yyyy-MM-dd").format(expDate);
		return sDate;

	}

	public void setExDate(String sDate) throws ParseException {
		Date ddate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		expDate = ddate;
	}
	 
	@Override
	public String toString() {
		return super.toString() + "; DriverID = " + this.driverId + "; Expiration date inspection certificate = " + getExDate();
	}

	
}
