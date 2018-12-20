package com.qaprosoft.yakubovichAlexander.employee.techstaff.dev;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.main.java.interfaces.IRelax;
import com.qaprosoft.yakubovichAlexander.main.java.interfaces.ISmoke;

public class Automation extends Development implements ISmoke, IRelax {
	private final static Logger LOGGER = LogManager.getLogger(Automation.class);

	@Override
	public String toString() {
		return super.toString() + "; KindOfTest=" + kindOfTest + "\n";
	}

	private String kindOfTest;

	public String getKindOfTest() {
		return kindOfTest;
	}

	public void setKindOfTest(String kindPfTest) {
		this.kindOfTest = kindPfTest;
	}

	@Override
	public void work() {
		LOGGER.info("Development automation tests");
	}

	@Override
	public void smoke() {
		LOGGER.info("Automation smokes 3 times a day");

	}

	@Override
	public void relax() {
		LOGGER.info("Automation were on sea in 2016 year");

	}

}
