package com.qaprosoft.yakubovichAlexander.project;

import java.util.ArrayList;

import com.qaprosoft.yakubovichAlexander.main.java.employee.Employee;

public class Project {

	private ArrayList<Employee> team = new ArrayList<Employee>();
	private String typeProject;
	private int cost;

	public ArrayList<Employee> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<Employee> team) {
		this.team = team;

	}

	public String getTypeProject() {
		return typeProject;
	}

	public void setTypeProject(String typeProject) {
		this.typeProject = typeProject;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
