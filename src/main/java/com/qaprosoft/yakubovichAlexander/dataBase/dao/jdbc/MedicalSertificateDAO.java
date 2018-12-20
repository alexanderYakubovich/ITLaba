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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.MedicalSertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IMedicalSertificateDAO;

public class MedicalSertificateDAO extends AbstractDao implements IMedicalSertificateDAO {

	private static final Logger LOGGER = LogManager.getLogger(MedicalSertificateDAO.class);

	@Override
	public void insert(MedicalSertificate ms) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("INSERT INTO  Medical_sertificates (valid_until,driver_id) VALUES (?,?)");
			ps.setString(1, ms.getValidUntil());
			ps.setLong(2, ms.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}

	}

	public MedicalSertificate getByDriverId(long id)
			throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalSertificate mc = new MedicalSertificate();

		try {
			ps = connection.prepareStatement("SELECT * FROM Medical_sertificates med where med.driver_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildMedicalSertificate(rs, mc);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return mc;
	}

	@Override
	public MedicalSertificate getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalSertificate ms = new MedicalSertificate();

		try {
			ps = connection.prepareStatement("SELECT * FROM Medical_sertificates med where med.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildMedicalSertificate(rs, ms);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return ms;
	}

	@Override
	public void update(MedicalSertificate ms) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Medical_sertificates SET valid_until=?, driver_id=?  WHERE id=?");

			ps.setString(1, ms.getValidUntil());
			ps.setLong(2, ms.getDriverId());
			ps.setLong(3, ms.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void updateByDriverId(MedicalSertificate ms) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Medical_sertificates SET valid_until=? WHERE driver_id=?");

			ps.setString(1, ms.getValidUntil());
			ps.setLong(2, ms.getDriverId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void delete(MedicalSertificate ms) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Medical_sertificates WHERE id=?");
			ps.setLong(1, ms.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void deleteByDriverId(MedicalSertificate ms) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Medical_sertificates WHERE driver_id=?");
			ps.setLong(1, ms.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<MedicalSertificate> getAll() throws SQLException, ParseException, IOException, InterruptedException {

		Connection connection = POOL.getConnection();

		List<MedicalSertificate> listMedicalSertificates = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Medical_sertificates med");
			while (rs.next()) {
				MedicalSertificate ms = new MedicalSertificate();
				buildMedicalSertificate(rs, ms);

				listMedicalSertificates.add(ms);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			rs.close();
		}
		return listMedicalSertificates;
	}

	protected void buildMedicalSertificate(ResultSet rs, MedicalSertificate ms) throws SQLException, ParseException {
		ms.setId(rs.getLong("med.id"));
		ms.setValidUntil(rs.getString("med.valid_until"));
		ms.setDriverId(rs.getInt("med.driver_id"));
	}
}
