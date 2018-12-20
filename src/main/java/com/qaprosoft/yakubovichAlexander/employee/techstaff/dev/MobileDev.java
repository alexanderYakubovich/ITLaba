package com.qaprosoft.yakubovichAlexander.employee.techstaff.dev;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.TechStaff;
import com.qaprosoft.yakubovichAlexander.main.java.employee.Employee;

public class MobileDev extends Development {
	private final static Logger LOGGER = LogManager.getLogger(MobileDev.class);

	@Override
	public String toString() {
		return super.toString() + "; PlatformName=" + platformName;
	}

	private String platformName;

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
		result = prime * result + getSalary();
		result = prime * result + getYear();
		result = prime * result + ((getProject() == null) ? 0 : getProject().hashCode());
		result = prime * result + ((platformName == null) ? 0 : platformName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Employee other = (Employee) obj;

		if (getCity() == null) {
			if (other.getCity() != null)
				return false;
		} else if (!getCity().equals(other.getCity()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getPosition() != other.getPosition())
			return false;
		if (getSalary() != other.getSalary())
			return false;
		if (getYear() != other.getYear())
			return false;

		TechStaff other1 = (TechStaff) obj;

		if (getProject() == null) {
			if (other1.getProject() != null)
				return false;
		} else if (!getProject().equals(other1.getProject()))
			return true;

		MobileDev other2 = (MobileDev) obj;

		if (platformName == null) {
			if (other2.platformName != null)
				return false;
		} else if (!platformName.equals(other2.platformName))
			return false;
		if (getClass() != obj.getClass())
			return false;

		return false;
	}

	@Override
	public void work() {
		LOGGER.info("Development mobile apps");
	}

}
