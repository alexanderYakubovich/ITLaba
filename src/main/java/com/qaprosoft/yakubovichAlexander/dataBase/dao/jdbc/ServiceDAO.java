package com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Service;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IServiceDAO;

public class ServiceDAO extends AbstractDao implements IServiceDAO {

	private static final Logger LOGGER = LogManager.getLogger(ServiceDAO.class);

	@Override
	public void insert(Service service) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("INSERT INTO  Services (name_station,number_cars) VALUES (?,?)");
			ps.setString(1, service.getNameStation());
			ps.setInt(2, service.getNumberCars());
			ps.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}

	}

	@Override
	public Service getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Service service = new Service();

		try {
			ps = connection.prepareStatement("SELECT * FROM Services s WHERE s.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildServices(rs, service);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return service;
	}

	@Override
	public void update(Service service) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Services SET name_station=?, number_cars=? WHERE id=?");

			ps.setString(1, service.getNameStation());
			ps.setInt(2, service.getNumberCars());
			ps.setLong(4, service.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void delete(Service service) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Services WHERE id=?");
			ps.setLong(1, service.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<Service> getAll() throws SQLException, ParseException, IOException, InterruptedException {

		Connection connection = POOL.getConnection();
		List<Service> listServices = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Services s");
			while (rs.next()) {
				Service services = new Service();
				buildServices(rs, services);
				listServices.add(services);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listServices;
	}

	private void buildServices(ResultSet rs, Service service) throws SQLException {
		service.setId(rs.getLong("s.id"));
		service.setNameStation(rs.getString("s.name_station"));
		service.setNumberCars(rs.getInt("s.number_cars"));
	}
}
