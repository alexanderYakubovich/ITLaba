package com.qaprosoft.yakubovichAlexander.dataBase.dao.services;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.AddressDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.ClientDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.OrderDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.PaymentDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc.RouteDAO;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Order;

public class OrderService {

	private OrderDAO orderDao = new OrderDAO();
	private PaymentDAO paymentDao = new PaymentDAO();
	private RouteDAO routeDao = new RouteDAO();
	private AddressDAO addressDao = new AddressDAO();
	private ClientDAO clientDao = new ClientDAO();
	

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	public PaymentDAO getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDAO paymentDao) {
		this.paymentDao = paymentDao;
	}

	public RouteDAO getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDAO routeDao) {
		this.routeDao = routeDao;
	}

	public AddressDAO getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}

	public ClientDAO getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}

	public Order getOrderById(long id) throws SQLException, IOException, InterruptedException, ParseException {
		Order order = orderDao.getById(id);
		order.setPayment(paymentDao.getByOrderId(id));
		order.setRoute(routeDao.getByOrderId(id));
		order.setClient(clientDao.getById(order.getClientId()));
		order.setAddressArrival(addressDao.getById(order.getAddressArriveId()));
		order.setAddressDeparture(addressDao.getById(order.getAddressDepartureId()));
		return order;
	}

}
