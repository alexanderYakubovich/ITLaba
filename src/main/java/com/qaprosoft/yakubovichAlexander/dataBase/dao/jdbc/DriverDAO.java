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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Driver;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IDriverDAO;

public class DriverDAO extends AbstractDao implements IDriverDAO {
	private static final Logger LOGGER = LogManager.getLogger(DriverDAO.class);

	@Override
	public void insert(Driver driver) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Users (name,rating,number_phone) VALUES (?,?,?)");
			ps.setString(1, driver.getName());
			ps.setDouble(2, driver.getRating());
			ps.setString(3, driver.getNumberPhone());
			ps.executeUpdate();

			ps1 = connection.prepareStatement("INSERT INTO  Drivers (id, user_id) VALUES (?,?)");
			ps1.setLong(1, driver.getId());
			ps1.setLong(2, driver.getUserId());
			ps1.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			ps1.close();
		}
	}

	@Override
	public void update(Driver driver) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {
			ps = connection.prepareStatement("UPDATE Users SET name=?, rating=?, number_Phone=?  WHERE id=?");
			ps.setString(1, driver.getName());
			ps.setDouble(2, driver.getRating());
			ps.setString(3, driver.getNumberPhone());
			ps.setLong(4, driver.getId());
			ps.executeUpdate();

			ps1 = connection.prepareStatement("UPDATE Drivers SET user_id=?  WHERE id=?");
			ps1.setLong(1, driver.getUserId());
			ps1.setLong(2, driver.getId());
			ps1.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			ps1.close();
		}
	}

	@Override
	public Driver getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		Driver driver = new Driver();
		try {
			ps1 = connection
					.prepareStatement("SELECT * FROM Drivers d LEFT JOIN Users u ON u.id = d.user_id  where d.id = ?");
			ps1.setLong(1, id);
			rs = ps1.executeQuery();
			if (rs.next()) {
				buildDriver(rs, driver);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps1.close();
			rs.close();
		}
		return driver;
	}

	@Override
	public void delete(Driver driver) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps2 = null;
		try {
			ps2 = connection.prepareStatement("DELETE FROM  Drivers WHERE id=?");
			ps2.setLong(1, driver.getId());
			ps2.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps2.close();
		}
	}

	@Override
	public List<Driver> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Driver> listDrivers = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Drivers d" + " LEFT JOIN Users u ON d.user_id = u.id");
			while (rs.next()) {
				Driver driver = new Driver();
				buildDriver(rs, driver);
				listDrivers.add(driver);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listDrivers;
	}

	private void buildDriver(ResultSet rs, Driver driver) throws SQLException {
		driver.setId(rs.getLong("u.id"));
		driver.setName(rs.getString("u.name"));
		driver.setRating(rs.getDouble("u.rating"));
		driver.setNumberPhone(rs.getString("u.number_phone"));
		driver.setUserId(rs.getInt("d.user_id"));
		driver.setId(rs.getLong("d.id"));
	}


}
