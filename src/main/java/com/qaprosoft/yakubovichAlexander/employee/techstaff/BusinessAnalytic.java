package com.qaprosoft.yakubovichAlexander.employee.techstaff;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BusinessAnalytic extends TechStaff {
	private final static Logger LOGGER = LogManager.getLogger(BusinessAnalytic.class);

	@Override
	public void work() {
		LOGGER.info("Work with customer");
	}

}