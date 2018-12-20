package com.qaprosoft.yakubovichAlexander.employee.techstaff.dev;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.TechStaff;

public abstract class Development extends TechStaff {

	@Override
	public String toString() {
		return super.toString() + "; ProjectLanguage=" + projectLanguage;
	}

	private String projectLanguage;

	public String getProjectLanguage() {
		return projectLanguage;
	}

	public void setProjectLanguage(String projectLanguage) {
		this.projectLanguage = projectLanguage;
	}

	public abstract void work();
}
