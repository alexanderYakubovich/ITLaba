package com.qaprosoft.yakubovichAlexander.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.qaprosoft.yakubovichAlexander.main.java.exception.IncorrectSalaryException;
import com.qaprosoft.yakubovichAlexander.main.java.exception.IncorrectYearException;
import com.qaprosoft.yakubovichAlexander.main.java.positionEnum.PositionEnum;

/**
 * The description of employees.
 * 
 * @author Yakubovich_Aleksandr
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Employee {
	@XmlAttribute
	private int ID;

	private Date date;

	/**
	 * The value is used for string storage and describe name of employee.
	 */

	private String name;
	/**
	 * The value is used for string storage and describe where living employee.
	 */

	private String city;
	/**
	 * The value is used for integer storage and describe the birth year of
	 * employee.
	 */

	private int year;
	/**
	 * The value is used for string storage and describe position of employee.
	 */

	private PositionEnum position;
	/**
	 * The value is used for integer storage and describe the salary which get
	 * employees.
	 */

	private int salary;

	public abstract void work();

	/**
	 * Getter of the employee's name.
	 * 
	 * @return to description of the return value.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is a setter which sets the name
	 * 
	 * @param name - the name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return to description of the return value.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This is a setter which sets the city
	 * 
	 * @param city - the city to be set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return to description of the return value.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This is a setter which sets the year
	 * 
	 * @param year - the year to be set
	 * @throws IncorrectYearException
	 */
	public void setYear(int year) throws IncorrectYearException {

		if (year < 1960 && year > 2000) {
			throw new IncorrectYearException("You inter incorrect year");
		}

		this.year = year;
	}

	/**
	 * @return to description of the return value.
	 */
	public PositionEnum getPosition() {
		return position;
	}

	/**
	 * This is a setter which sets the position
	 * 
	 * @param position - the position to be set
	 */
	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	/**
	 * @return to description of the return value.
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * This is a setter which sets the salary.
	 * 
	 * @param salalry - the salary to be set.
	 * @return
	 * @throws IncorrectSalaryException
	 */
	public void setSalary(int salary) throws IncorrectSalaryException {

		if (salary <= 0) {
			throw new IncorrectSalaryException("You input incorrect salalry");
		}
		this.salary = salary;
	}

	public String getDate() {
		String sDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return sDate;

	}

	public void setDate(String sDate) throws ParseException {
		Date ddate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		date = ddate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String toString() {
		return "Name=" + this.name + "; ID=" + this.ID + "; City=" + this.city + "; Year=" + this.year + "; Salary="
				+ this.salary + "; Date=" + getDate() + "; Position=" + this.position;
	}
}
