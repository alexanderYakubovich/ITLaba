package com.qaprosoft.yakubovichAlexander.dataBase.dao.services;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.DriverDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.DriverLicenseDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.InspectionCertificateDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.InsuranceDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.MedicalSertificateDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Driver;

public class DriverService {
	DriverDAO driverDao = new DriverDAO();
	DriverLicenseDAO driverlicenseDao = new DriverLicenseDAO();
	InspectionCertificateDAO inspectionCertificateDAO = new InspectionCertificateDAO();
	InsuranceDAO insuranceDAO = new InsuranceDAO();
	MedicalSertificateDAO medicalSertificateDAO = new MedicalSertificateDAO();

	public void addDriver(Driver driver) throws SQLException, IOException, InterruptedException, ParseException {
		driverDao.insert(driver);
		driverlicenseDao.insert(driver.getDriverLicense());
		inspectionCertificateDAO.insert(driver.getInspectionCertificate());
		insuranceDAO.insert(driver.getInsurance());
		medicalSertificateDAO.insert(driver.getMedicalSertificate());
	}

	public Driver getDriverById(long id) throws SQLException, IOException, InterruptedException, ParseException {
		Driver driver = driverDao.getById(id);
		driver.setDriverLicense(driverlicenseDao.getByDriverId(id));
		driver.setInspectionCertificate(inspectionCertificateDAO.getByDriverId(id));
		driver.setInsurance(insuranceDAO.getByDriverId(id));
		driver.setMedicalSertificate(medicalSertificateDAO.getByDriverId(id));
		return driver;
	}

	public void updateDriverById(Driver driver) throws SQLException, IOException, InterruptedException {
		driverDao.update(driver);
		driverlicenseDao.updateByDriverId(driver.getDriverLicense());
		inspectionCertificateDAO.updateByDriverId(driver.getInspectionCertificate());
		insuranceDAO.updateByDriverId(driver.getInsurance());
		medicalSertificateDAO.updateByDriverId(driver.getMedicalSertificate());
	}
	
	public void deleteByDriverId(Driver driver) throws SQLException, IOException, InterruptedException {
		driverDao.delete(driver);
		driverlicenseDao.deleteByDriverId(driver.getDriverLicense());
		inspectionCertificateDAO.deleteByDriverId(driver.getInspectionCertificate());
		insuranceDAO.deleteByDriverId(driver.getInsurance());
		medicalSertificateDAO.deleteByDriverId(driver.getMedicalSertificate());
	}
}