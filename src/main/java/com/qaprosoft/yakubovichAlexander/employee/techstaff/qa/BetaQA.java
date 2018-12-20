package com.qaprosoft.yakubovichAlexander.employee.techstaff.qa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BetaQA extends QA {

	private final static Logger LOGGER = LogManager.getLogger(BetaQA.class);

	@Override
	public void work() {
		LOGGER.info("BETA testing");
	}

}