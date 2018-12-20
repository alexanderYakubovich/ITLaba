package com.qaprosoft.yakubovichAlexander.dataBase.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.AddressDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.CarDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.CarModelDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.ClientDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.DriverDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.DriverLicenseDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.InspectionCertificateDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.InsuranceDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.MedicalSertificateDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.OrderDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.PaymentDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.RouteDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.ServiceDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.services.DriverService;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.services.OrderService;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Address;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Car;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.CarModel;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Client;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Driver;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.DriverLicense;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.InspectionCertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Insurance;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.MedicalSertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Order;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Payment;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Route;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Service;

public class JDBCRunner {

	private static final Logger LOGGER = LogManager.getLogger(JDBCRunner.class);

	public static void main(String[] args) throws SQLException, ParseException, IOException, InterruptedException {

		DriverDAO dr = new DriverDAO();
		dr.getById(1);
		MedicalSertificateDAO meds = new MedicalSertificateDAO();
		InsuranceDAO ins = new InsuranceDAO();
		InspectionCertificateDAO insp = new InspectionCertificateDAO();
		CarDAO c = new CarDAO();
		CarModelDAO cm = new CarModelDAO();
		ServiceDAO s = new ServiceDAO();
		ClientDAO cl = new ClientDAO();
		OrderDAO or = new OrderDAO();
		AddressDAO ad = new AddressDAO();
		RouteDAO r = new RouteDAO();
		PaymentDAO p = new PaymentDAO();
		DriverLicenseDAO drl = new DriverLicenseDAO();

		MedicalSertificate medical = new MedicalSertificate();
		medical.setValidUntil("2000-11-11");
		medical.setDriverId(1);
		medical.setId(2);

//		meds.update(medical);
//		meds.insert(medical);
//		meds.delete(medical);
//		LOGGER.info(meds.getAll());
//		LOGGER.info(meds.getById(9));

		Insurance insurance = new Insurance();
		insurance.setValidity(11111);
		insurance.setCity("111111");
		insurance.setDrivingExperience(1111);
		insurance.setDriverId(1);
		insurance.setId(2);

//		ins.insert(insurance);
//		ins.delete(insurance);
//		ins.update(insurance);
//		LOGGER.info(ins.getById(1));
//		LOGGER.info(ins.getAll());

		InspectionCertificate inspection = new InspectionCertificate();
		inspection.setExDate("2000-11-11");
		inspection.setId(111);
		inspection.setDriverId(1);

//		insp.update(inspection);
//		insp.insert(inspection);
//		insp.delete(inspection);
//		LOGGER.info(insp.getAll());
//		LOGGER.info(insp.getById(5));

		CarModel carModel = new CarModel();
		carModel.setColor("BLUE");
		carModel.setModel("AUDI");
		carModel.setNumber("1111");
		carModel.setId(11);

//		cm.update(carModel);
//		cm.insert(carModel);
//		cm.delete(carModel);
//		LOGGER.info(cm.getAll());
//		LOGGER.info(cm.getById(1));

		Car car = new Car();
		car.setCarModelId(8);
		car.setDriverId(9);
		car.setId(20);

//		c.update(car);
//		c.insert(car);
//		c.delete(car);
//		LOGGER.info(c.getAll());
//		LOGGER.info(c.getById(1));

		Driver driver = new Driver();
		driver.setName("OLEGGG");
		driver.setRating(4.4);
		driver.setNumberPhone("80447360201");
		driver.setUserId(10);
		driver.setId(1);

//		dr.insert(driver);
//		dr.update(driver);
//		dr.delete(driver);
//		LOGGER.info(dr.getById(1));
//		LOGGER.info(dr.getAll());

		Service service = new Service();
		service.setNameStation("AAA");
		service.setNumberCars(99999999);
		service.setId(11);

//		s.update(service);
//		s.insert(service);
//		s.delete(service);
//		LOGGER.info(s.getAll());
//		LOGGER.info(s.getById(1));

		Client client = new Client();
		client.setName("GRISHA");
		client.setRating(1.1);
		client.setNumberPhone("80295782744");
		client.setId(20);
		client.setUserClId(20);
		client.setId(228);

//		cl.insert(client);
//		cl.update(client);
//		cl.delete(client);
//		LOGGER.info(cl.getById(1));
//		LOGGER.info(cl.getAll());

		Order order = new Order();
		order.setCost(20.2);
		order.setClientId(10);
		order.setAddressDepartureId(2);
		order.setAddressArriveId(2);
		order.setId(228L);

//		or.insert(order);
//		or.update(order);
//		or.delete(order);
//		LOGGER.info(or.getById(1));
//		LOGGER.info(or.getAll());

		Address address = new Address();
//		address.setId(21);
		address.setNumberHome(200);
		address.setStreet("200");

		ad.insert(address);
//		ad.update(address);
//		ad.delete(address);
//		LOGGER.info(ad.getById(1));
//		LOGGER.info(ad.getAll());

		Route route = new Route();
		route.setId(50);
		route.setDistance(5);
		route.setTime(5);
		route.setOrderId(5);

//		r.insert(route);
//		r.update(route);
//		r.delete(route);
//		LOGGER.info(r.getById(1));
//		LOGGER.info(r.getAll());

		Payment pay = new Payment();
		pay.setId(100);
		pay.setType("222");
		pay.setOrderId(1);

//		p.insert(pay);
//		p.update(pay);
//		p.delete(pay);
//		LOGGER.info(p.getById(1));
//		LOGGER.info(p.getAll());

		DriverLicense drLicense = new DriverLicense();
		drLicense.setId(2);
		drLicense.setExDate("2000-11-11");
		drLicense.setDriverId(1);

//		drl.insert(drLicense);
//		drl.update(drLicense);
//		drl.delete(drLicense);
//		LOGGER.info(drl.getById(2));
//		LOGGER.info(drl.getAll());
//		LOGGER.info(drl.getByDriverId(5));

		Driver driverSelect = new Driver();
		driverSelect.setName("GOGGI");
		driverSelect.setRating(4.4);
		driverSelect.setNumberPhone("GOGGI");
		driverSelect.setUserId(2);
		driverSelect.setDriverLicense(drLicense);
		driverSelect.setInspectionCertificate(inspection);
		driverSelect.setInsurance(insurance);
		driverSelect.setMedicalSertificate(medical);

		DriverService driverService = new DriverService();
//		driverService.addDriver(driverSelect);
//		LOGGER.info(driverService.getDriverById(2));
//		driverService.updateDriverById(driverSelect);
//		driverService.deleteByDriverId(driverSelect);
//
		OrderService orderService = new OrderService();
		LOGGER.info(orderService.getOrderById(8));

	}

}
