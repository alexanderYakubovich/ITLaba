package com.qaprosoft.yakubovichAlexander.dataBase.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Car;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.ICarDAO;


public class CarDAO extends AbstractDao implements ICarDAO {
	private static final Logger LOGGER = LogManager.getLogger(CarDAO.class);

	@Override
	public void insert(Car car) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Cars (car_model_id, driver_id) VALUES (?,?)");
			ps.setLong(1, car.getCarModelId());
			ps.setLong(2, car.getDriverId());
			ps.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void update(Car car) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Cars SET car_model_id, driver_id=? WHERE id=?");
			ps.setLong(1, car.getCarModelId());
			ps.setLong(2, car.getDriverId());

			ps.setLong(4, car.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public Car getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car car = new Car();

		try {
			ps = connection.prepareStatement("SELECT * FROM Cars c where c.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCar(rs, car);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return car;
	}

	@Override
	public void delete(Car car) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps1 = null;
		try {
			ps1 = connection.prepareStatement("DELETE FROM Cars WHERE id=?");
			ps1.setLong(1, car.getId());
			ps1.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps1.close();
		}
	}

	@Override
	public List<Car> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Car> listCars = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Cars c");
			while (rs.next()) {
				Car car = new Car();
				buildCar(rs, car);
				listCars.add(car);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();

		}
		return listCars;
	}

	private void buildCar(ResultSet rs, Car car) throws SQLException {
		car.setId(rs.getLong("c.id"));
		car.setCarModelId(rs.getInt("c.car_model_id"));
		car.setDriverId(rs.getInt("c.driver_id"));
	}

}
