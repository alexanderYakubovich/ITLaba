package com.qaprosoft.yakubovichAlexander.dataBase.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.qaprosoft.yakubovichAlexander.dataBase.entity.Route;

public interface IRouteDAO extends IDao<Route> {
	Route getByOrderId(long id) throws SQLException, IOException, InterruptedException, ParseException;
}
