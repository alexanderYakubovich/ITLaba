package com.qaprosoft.yakubovichAlexander.dataBase.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalSertificate extends Id{

	private Date validUntil;
	private long driverId;

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	
	public String getValidUntil() {
		String sDate = new SimpleDateFormat("yyyy-MM-dd").format(validUntil);
		return sDate;

	}

	public void setValidUntil(String sDate) throws ParseException {
		Date ddate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		validUntil = ddate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "; Driver ID = " + this.driverId + 
				"; Medical sertificate valid until = " + getValidUntil();
	}

	
}
