package com.qaprosoft.yakubovichAlexander.dataBase.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverLicense extends Id{

	private Date exDate;
	private long driverId;

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public String getExDate() {
		String sDate = new SimpleDateFormat("yyyy-MM-dd").format(exDate);
		return sDate;

	}

	public void setExDate(String sDate) throws ParseException {
		Date ddate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		exDate = ddate;
	}


	@Override
	public String toString() {
		return super.toString() +  "; Driver ID = " + this.driverId + "; Expiration date driver license = " + getExDate();
	}

	
}