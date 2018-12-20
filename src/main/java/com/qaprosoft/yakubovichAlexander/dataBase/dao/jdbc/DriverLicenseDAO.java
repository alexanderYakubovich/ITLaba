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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.DriverLicense;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IDriverLicenseDAO;

public class DriverLicenseDAO extends AbstractDao implements IDriverLicenseDAO {

	private static final Logger LOGGER = LogManager.getLogger(DriverLicenseDAO.class);

	@Override
	public void insert(DriverLicense drLicense) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("INSERT INTO Driver_licenses (ex_date, driver_id) VALUES (?,?)");
			ps.setString(1, drLicense.getExDate());
			ps.setLong(2, drLicense.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public DriverLicense getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		DriverLicense drLicense = new DriverLicense();

		try {
			ps = connection.prepareStatement("SELECT * FROM Driver_licenses drl where drl.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildDriverLicense(rs, drLicense);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return drLicense;
	}

	public DriverLicense getByDriverId(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		DriverLicense drLicense = new DriverLicense();

		try {
			ps = connection.prepareStatement("SELECT * FROM Driver_licenses drl where drl.driver_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildDriverLicense(rs, drLicense);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return drLicense;
	}
	@Override
	public void update(DriverLicense drLicense) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("UPDATE Driver_licenses SET ex_date=?, driver_id=?  WHERE id=?");
			ps.setString(1, drLicense.getExDate());
			ps.setLong(2, drLicense.getDriverId());
			ps.setLong(3, drLicense.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void updateByDriverId(DriverLicense drLicense) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("UPDATE Driver_licenses SET ex_date=? WHERE driver_id=?");
			ps.setString(1, drLicense.getExDate());
			ps.setLong(2, drLicense.getDriverId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}
	
	@Override
	public void delete(DriverLicense drLicense) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("DELETE FROM Driver_licenses WHERE id=?");
			ps.setLong(1, drLicense.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void deleteByDriverId(DriverLicense drLicense) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("DELETE FROM Driver_licenses WHERE driver_id=?");
			ps.setLong(1, drLicense.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}
	
	@Override
	public List<DriverLicense> getAll() throws SQLException, ParseException, IOException, InterruptedException {

		Connection connection = POOL.getConnection();

		List<DriverLicense> listDriverLicenses = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Driver_licenses drl ");

			while (rs.next()) {
				DriverLicense drLicense = new DriverLicense();
				buildDriverLicense(rs, drLicense);
				listDriverLicenses.add(drLicense);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listDriverLicenses;
	}

	private void buildDriverLicense(ResultSet rs, DriverLicense drLicense) throws SQLException, ParseException {
		drLicense.setId(rs.getLong("drl.id"));
		drLicense.setExDate(rs.getString("drl.ex_date"));
		drLicense.setDriverId(rs.getInt("drl.driver_id"));
	}

}
