package com.qaprosoft.yakubovichAlexander.employee.techstaff.qa;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.TechStaff;

public abstract class QA extends TechStaff {

	@Override
	public String toString() {
		return super.toString() + "; Device=" + device;
	}

	private String device;

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public abstract void work();
}