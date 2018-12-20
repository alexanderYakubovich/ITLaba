package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public class Order extends Id {

	private double cost;
	private long clientId;
	private long addressArriveId;
	private long addressDepartureId;
	private Driver driver;
	private Client client;
	private Address addressArrival;
	private Address addressDeparture;
	private Route route;
	private Payment payment;

	
	
	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public long getClientId() {
		return clientId;
	}



	public void setClientId(long clientId) {
		this.clientId = clientId;
	}



	public long getAddressArriveId() {
		return addressArriveId;
	}



	public void setAddressArriveId(long addressArriveId) {
		this.addressArriveId = addressArriveId;
	}



	public long getAddressDepartureId() {
		return addressDepartureId;
	}



	public void setAddressDepartureId(long addressDepartureId) {
		this.addressDepartureId = addressDepartureId;
	}



	public Driver getDriver() {
		return driver;
	}



	public void setDriver(Driver driver) {
		this.driver = driver;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Address getAddressArrival() {
		return addressArrival;
	}



	public void setAddressArrival(Address addressArrival) {
		this.addressArrival = addressArrival;
	}



	public Address getAddressDeparture() {
		return addressDeparture;
	}



	public void setAddressDeparture(Address addressDeparture) {
		this.addressDeparture = addressDeparture;
	}



	public Route getRoute() {
		return route;
	}



	public void setRoute(Route route) {
		this.route = route;
	}



	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return  "\n" + "Order:" + super.toString() + "; Cost=" + cost + ", clientId=" + clientId + ", addressArriveId=" + addressArriveId
				+ ", addressDepartureId=" + addressDepartureId + "\n" + "Client:" + client + "\n"
				+ "AddressArrival:"  + addressArrival + "\n" + "AddressDeparture:" + addressDeparture + "\n" + "Route:" + route
				+ "\n" + "Payment:" + payment;
	}

}
