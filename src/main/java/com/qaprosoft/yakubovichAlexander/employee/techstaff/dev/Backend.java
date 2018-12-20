package com.qaprosoft.yakubovichAlexander.employee.techstaff.dev;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.main.java.interfaces.IDriveCar;
import com.qaprosoft.yakubovichAlexander.main.java.interfaces.ISmoke;

public class Backend extends Development implements IDriveCar, ISmoke {
	private final static Logger LOGGER = LogManager.getLogger(Backend.class);

	@Override
	public void work() {
		LOGGER.info("Development back end side");
	}

	@Override
	public void driveCar() {
		LOGGER.info("Backend goes to work about 45 minutes");

	}

	@Override
	public void smoke() {
		LOGGER.info("Backend smokes about 5 times a day");

	}

}
