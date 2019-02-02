package com.qaprosoft.yakubovichAlexander.dataBase.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.AddressMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.CarModelMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.CarMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.ClientMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.DriverLicenseMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.DriverMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.InspectionCertificateMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.InsuranceMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.MedicalSertificateMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.OrderMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.PaymentMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.RouteMyBatis;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis.ServiceMyBatis;

public class MyBatisRunner {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);

	public static void main(String[] args) throws SQLException, ParseException, IOException, InterruptedException {

//		AddressMyBatis myBatisAddress = new AddressMyBatis();
//		LOGGER.info(myBatisAddress.getById(1));
//
		CarMyBatis myBatisCar = new CarMyBatis();
		LOGGER.info(myBatisCar.getById(4));
//		LOGGER.info(myBatisCar.getAll());
//
//		CarModelMyBatis myBatisCarmodel = new CarModelMyBatis();
//		LOGGER.info(myBatisCarmodel.getById(1));
//
//		ClientMyBatis myBatisClient = new ClientMyBatis();
//		LOGGER.info(myBatisClient.getById(2));
//
//		DriverLicenseMyBatis driverLicenseMyBatis = new DriverLicenseMyBatis();
//		LOGGER.info(driverLicenseMyBatis.getById(1));
//
//		DriverMyBatis driverMyBatis = new DriverMyBatis();
//		LOGGER.info(driverMyBatis.getById(3));
//
//		InspectionCertificateMyBatis inspectionCertificateMyBatis = new InspectionCertificateMyBatis();
//		LOGGER.info(inspectionCertificateMyBatis.getById(4));
//
//		MedicalSertificateMyBatis medicalSertificateMyBatis = new MedicalSertificateMyBatis();
//		LOGGER.info(medicalSertificateMyBatis.getById(2));
//
//		OrderMyBatis OrderMyBatis = new OrderMyBatis();
//		LOGGER.info(OrderMyBatis.getById(4));
//
//		RouteMyBatis routeMyBatis = new RouteMyBatis();
//		LOGGER.info(routeMyBatis.getById(3));
//
//		ServiceMyBatis serviceMyBatis = new ServiceMyBatis();
//		LOGGER.info(serviceMyBatis.getById(3));
//		LOGGER.info(serviceMyBatis.getAll());
//
//		PaymentMyBatis paymentMyBatis = new PaymentMyBatis();
//		LOGGER.info(paymentMyBatis.getById(4));
//
//		InsuranceMyBatis insuranceMyBatis = new InsuranceMyBatis();
//		LOGGER.info(insuranceMyBatis.getById(3));
	}

}
