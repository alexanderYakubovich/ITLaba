package com.qaprosoft.yakubovichAlexander.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Automation;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.MobileDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.WebDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.BetaQA;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.ManualQA;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Accountant;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.CEO;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Cleaner;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Lawyer;

@XmlRootElement(name = "ITCompany")
public class ITCompany {

    @XmlElement(name = "Accountant")
    private List<Accountant> accountantList;

    @XmlElement(name = "CEO")
    private List<CEO> ceoList;

    @XmlElement(name = "Lawyer")
    private List<Lawyer> lawyerList;

    @XmlElement(name = "Cleaner")
    private List<Cleaner> cleanerList;

    @XmlElement(name = "MobileDev")
    private List<MobileDev> mobileDev;

    @XmlElement(name = "WebDev")
    private List<WebDev> webDevList;

    @XmlElement(name = "Automation")
    private List<Automation> automatList;

    @XmlElement(name = "ManualQA")
    private List<ManualQA> manualQAList;

    @XmlElement(name = "BetaQA")
    private List<BetaQA> betaQAList;

    public ITCompany() {
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
