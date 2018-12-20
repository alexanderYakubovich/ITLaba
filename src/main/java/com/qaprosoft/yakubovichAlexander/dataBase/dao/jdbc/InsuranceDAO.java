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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Insurance;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IInsuranceDAO;


public class InsuranceDAO extends AbstractDao implements IInsuranceDAO {

	private static final Logger LOGGER = LogManager.getLogger(InsuranceDAO.class);

	@Override
	public void insert(Insurance insurance) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"INSERT INTO  Insurances (validity, city, driving_experience,driver_id) VALUES (?,?,?,?)");
			ps.setInt(1, insurance.getValidity());
			ps.setString(2, insurance.getCity());
			ps.setInt(3, insurance.getDrivingExpirience());
			ps.setLong(4, insurance.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public Insurance getByDriverId(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Insurance insurance = new Insurance();

		try {
			ps = connection.prepareStatement("SELECT * FROM Insurances i where i.driver_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildInsurance(rs, insurance);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return insurance;
	}
	
	@Override
	public Insurance getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Insurance insurance = new Insurance();

		try {
			ps = connection.prepareStatement("SELECT * FROM Insurances i where i.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildInsurance(rs, insurance);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return insurance;
	}

	@Override
	public void update(Insurance insurance) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"UPDATE Insurances SET validity=?, city=?, driving_experience=?, driver_id=?  WHERE id=?");

			ps.setInt(1, insurance.getValidity());
			ps.setString(2, insurance.getCity());
			ps.setInt(3, insurance.getDrivingExpirience());
			ps.setLong(4, insurance.getDriverId());
			ps.setLong(5, insurance.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}

	}

	public void updateByDriverId(Insurance insurance) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"UPDATE Insurances SET validity=?, city=?, driving_experience=? WHERE driver_id=?");

			ps.setInt(1, insurance.getValidity());
			ps.setString(2, insurance.getCity());
			ps.setInt(3, insurance.getDrivingExpirience());
			ps.setLong(4, insurance.getDriverId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}

	}

	
	@Override
	public void delete(Insurance insurance) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Insurances WHERE id=?");
			ps.setLong(1, insurance.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void deleteByDriverId(Insurance insurance) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Insurances WHERE driver_id=?");
			ps.setLong(1, insurance.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}
	
	@Override
	public List<Insurance> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		List<Insurance> listInsurances = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Insurances i");
			while (rs.next()) {
				Insurance insurance = new Insurance();
				buildInsurance(rs, insurance);
				listInsurances.add(insurance);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listInsurances;
	}

	private void buildInsurance(ResultSet rs, Insurance insurance) throws SQLException {
		insurance.setId(rs.getLong("i.id"));
		insurance.setValidity(rs.getInt("i.validity"));
		insurance.setCity(rs.getString("i.city"));
		insurance.setDrivingExperience(rs.getInt("i.driving_experience"));
		insurance.setDriverId(rs.getInt("i.driver_id"));
	}

}
