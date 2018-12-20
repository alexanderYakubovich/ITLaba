package com.qaprosoft.yakubovichAlexander.runner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Automation;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Backend;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.MobileDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.WebDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.ManualQA;
import com.qaprosoft.yakubovichAlexander.linkedList.LinkList;
import com.qaprosoft.yakubovichAlexander.main.java.employee.Employee;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.CEO;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.HR;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Lawyer;
import com.qaprosoft.yakubovichAlexander.main.java.exception.IncorrectNumberEmployeeException;
import com.qaprosoft.yakubovichAlexander.project.Project;
import com.qaprosoft.yakubovichAlexander.text.Text;

public class Runner {
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) throws Exception {

//		Interfaces

		Backend backend = new Backend();
		Automation automation = new Automation();
		WebDev webDev = new WebDev();
		CEO ceo = new CEO();

		backend.driveCar();
		backend.smoke();
		automation.smoke();
		webDev.smoke();
		automation.relax();
		ceo.relax();

//		Read & Write Text

		Text t = new Text();
		t.read();

//		POLIMORHISM

		Employee e = new HR();
		e.work();

//		DATE	

		Employee lawyer = new Lawyer();
		lawyer.setDate("2018-10-12");
		String dat = lawyer.getDate();
		LOGGER.info("Date of release " + dat);

//		PROJECT COST
		getProjectCost("Mobile", 0, 3, 2, 3, 2);

		getProjectCost("Web", 4, 0, 3, 4, 3);

		getProjectCost("QA", 0, 0, 0, 5, 6);

//		LINKEDLIST

		LinkList ll = new LinkList();
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(3);
		ll.addNode(4);
		ll.addIndex(111, 3);
		ll.deleteIndex(3);
		ll.printList();

		LOGGER.info(ll.getSize());

	}

//		Project

	public static ArrayList<MobileDev> createMobileEmployeeList(int humanMobile)
			throws IncorrectNumberEmployeeException {
		ArrayList<MobileDev> mobileDevList = new ArrayList<>();
		if (humanMobile <= 0) {
			throw new IncorrectNumberEmployeeException("You enter incorrect number employees");
		}
		for (int i = 0; i < humanMobile; i++) {
			MobileDev mobileDev = new MobileDev();

			try {
				mobileDev.setSalary(240);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			mobileDevList.add(mobileDev);
		}

		return mobileDevList;
	}

	public static ArrayList<WebDev> createWebEmployeeList(int humanWeb) throws IncorrectNumberEmployeeException {
		ArrayList<WebDev> webDevList = new ArrayList<>();
		if (humanWeb <= 0) {
			throw new IncorrectNumberEmployeeException("You enter incorrect number employees");
		}
		for (int i = 0; i < humanWeb; i++) {
			WebDev webDev = new WebDev();
			try {
				webDev.setSalary(500);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			webDevList.add(webDev);
		}
		return webDevList;
	}

	public static ArrayList<Backend> createBackendEmployeeList(int humanBackend)
			throws IncorrectNumberEmployeeException {
		ArrayList<Backend> backendList = new ArrayList<>();
		if (humanBackend <= 0) {
			throw new IncorrectNumberEmployeeException("You enter incorrect number employees");
		}
		for (int i = 0; i < humanBackend; i++) {
			Backend backend = new Backend();
			try {
				backend.setSalary(80);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			backendList.add(backend);
		}
		return backendList;
	}

	public static ArrayList<Automation> createAutomationQAEmployeeList(int humanAutomationQA)
			throws IncorrectNumberEmployeeException {
		ArrayList<Automation> automationQAList = new ArrayList<>();
		if (humanAutomationQA <= 0) {
			throw new IncorrectNumberEmployeeException("You enter incorrect number employees");
		}
		for (int i = 0; i < humanAutomationQA; i++) {
			Automation automation = new Automation();
			try {
				automation.setSalary(180);
			} catch (Exception e) {
				LOGGER.error(e);
			}
			automationQAList.add(automation);
		}
		return automationQAList;
	}

	public static ArrayList<ManualQA> createManualQAEmployeeList(int humanManualQA)
			throws IncorrectNumberEmployeeException {
		ArrayList<ManualQA> manualQAList = new ArrayList<>();
		if (humanManualQA <= 0) {
			throw new IncorrectNumberEmployeeException("You enter incorrect number employees");
		}
		for (int i = 0; i < humanManualQA; i++) {
			ManualQA manual = new ManualQA();
			try {
				manual.setSalary(120);
			} catch (Exception e) {
				LOGGER.error(e);
			}
			manualQAList.add(manual);
		}
		return manualQAList;
	}

	public static int getProjectCost(String typeProject, int humanWeb, int humanMobile, int humanBackend,
			int humanAutomationQA, int humanManualQA) throws Exception {

		int projectCost = 0;
		Project project = new Project();

		switch (typeProject) {

		case "Mobile":

			List<MobileDev> mobileList = createMobileEmployeeList(humanMobile);
			List<Automation> automationList = createAutomationQAEmployeeList(humanAutomationQA);
			List<ManualQA> manualList = createManualQAEmployeeList(humanManualQA);
			List<Backend> backendList = createBackendEmployeeList(humanBackend);
			List<Employee> employeeList = new LinkedList<>();
			employeeList.addAll(mobileList);
			employeeList.addAll(automationList);
			employeeList.addAll(manualList);
			employeeList.addAll(backendList);

			for (Employee employee : employeeList) {
				projectCost = projectCost + employee.getSalary();
				project.setCost(projectCost);
			}

			LOGGER.info("Cost Mobile development: " + "\t" + projectCost + "$;");
			break;

		case "Web":
			List<Automation> automationListWeb = createAutomationQAEmployeeList(humanAutomationQA);
			List<ManualQA> manualListWeb = createManualQAEmployeeList(humanManualQA);
			List<Backend> backendListWeb = createBackendEmployeeList(humanBackend);
			List<WebDev> webDevList = createWebEmployeeList(humanWeb);
			List<Employee> employeeListWeb = new LinkedList<>();
			employeeListWeb.addAll(webDevList);
			employeeListWeb.addAll(automationListWeb);
			employeeListWeb.addAll(manualListWeb);
			employeeListWeb.addAll(backendListWeb);
			for (Employee employee : employeeListWeb) {
				projectCost = projectCost + employee.getSalary();
				project.setCost(projectCost);

			}

			LOGGER.info("Cost WEB development: " + "\t" + projectCost + "$;");
			break;

		case "QA":

			List<Automation> automationListQA = createAutomationQAEmployeeList(humanAutomationQA);
			List<ManualQA> manualListQA = createManualQAEmployeeList(humanManualQA);
			List<Employee> employeeListQA = new LinkedList<>();
			employeeListQA.addAll(automationListQA);
			employeeListQA.addAll(manualListQA);
			for (Employee employee : employeeListQA) {
				projectCost = projectCost + employee.getSalary();
				project.setCost(projectCost);

			}
			LOGGER.info("Cost Testing: " + "\t" + projectCost + "$;");
			break;

		default:

			LOGGER.info("You inter incorrect values");
		}

		return project.getCost();

	}

}
