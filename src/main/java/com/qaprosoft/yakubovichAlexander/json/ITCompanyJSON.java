package com.qaprosoft.yakubovichAlexander.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Automation;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.MobileDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.WebDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.BetaQA;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.ManualQA;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Accountant;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.CEO;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Cleaner;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Lawyer;

public class ITCompanyJSON {

	@JsonProperty("Accountant")
	private List<Accountant> accountantList;

	@JsonProperty("CEO")
	private List<CEO> ceoList;

	@JsonProperty("Lawyer")
	private List<Lawyer> lawyerList;

	@JsonProperty("Cleaner")
	private List<Cleaner> cleanerList;

	@JsonProperty("MobileDev")
	private List<MobileDev> mobileDev;

	@JsonProperty("WebDev")
	private List<WebDev> webDevList;

	@JsonProperty("Automation")
	private List<Automation> automatList;

	@JsonProperty("ManualQA")
	private List<ManualQA> manualQAList;

	@JsonProperty("BetaQA")
	private List<BetaQA> betaQAList;

	public ITCompanyJSON() {
		super();
	}

	public List<Accountant> getAccountantList() {
		return accountantList;
	}

	public List<CEO> getCeoList() {
		return ceoList;
	}

	public List<Lawyer> getLawyerList() {
		return lawyerList;
	}

	public List<Cleaner> getCleanerList() {
		return cleanerList;
	}

	public List<MobileDev> getMobileDevList() {
		return mobileDev;
	}

	public List<WebDev> getWebDevList() {
		return webDevList;
	}

	public List<Automation> getAutomatList() {
		return automatList;
	}

	public List<ManualQA> getManualQAList() {
		return manualQAList;
	}

	public List<BetaQA> getBetaQAList() {
		return betaQAList;
	}

}
