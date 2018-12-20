package com.qaprosoft.yakubovichAlexander.employee.techstaff;

import com.qaprosoft.yakubovichAlexander.main.java.employee.Employee;

public abstract class TechStaff extends Employee {

	@Override
	public String toString() {
		return super.toString() + "; Project=" + project;
	}

	private String project;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public abstract void work();

}