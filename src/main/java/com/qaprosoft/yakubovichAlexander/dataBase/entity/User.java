package com.qaprosoft.yakubovichAlexander.dataBase.entity;

public abstract class User extends Id{
	
private String name;
private double rating;
private String numberPhone;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public String getNumberPhone() {
	return numberPhone;
}
public void setNumberPhone(String numberPhone) {
	this.numberPhone = numberPhone;
}


public String toString() {
	return super.toString() + "; Name = " + this.name + "; Rating = " + this.rating + "; Number phone = " + this.numberPhone;
	
}

}
