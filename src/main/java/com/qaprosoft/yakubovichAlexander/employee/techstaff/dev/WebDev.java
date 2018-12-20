package com.qaprosoft.yakubovichAlexander.employee.techstaff.dev;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.main.java.interfaces.ISmoke;

public class WebDev extends Development implements ISmoke {
	private final static Logger LOGGER = LogManager.getLogger(WebDev.class);

	@Override
	public void work() {
		LOGGER.info("Development WEB");
	}

	@Override
	public void smoke() {
		LOGGER.info("MobileDev smokes 4 times a month");

	}

}