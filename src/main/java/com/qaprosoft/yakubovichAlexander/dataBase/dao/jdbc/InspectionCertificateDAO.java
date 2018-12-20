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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.InspectionCertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IInspectionCertificateDAO;

public class InspectionCertificateDAO extends AbstractDao implements IInspectionCertificateDAO {

	private static final Logger LOGGER = LogManager.getLogger(InspectionCertificateDAO.class);

	@Override
	public void insert(InspectionCertificate inspection) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("INSERT INTO  Inspections_certificates (exp_date, driver_id) VALUES (?,?)");
			ps.setString(1, inspection.getExDate());
			ps.setLong(2, inspection.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}

	}

	@Override
	public InspectionCertificate getById(long id)
			throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		InspectionCertificate inspection = new InspectionCertificate();

		try {
			ps = connection.prepareStatement("SELECT * FROM Inspections_certificates ic where ic.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildInspectionSertofocate(rs, inspection);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return inspection;
	}
	
	public InspectionCertificate getByDriverId(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		InspectionCertificate inspectionSertificate = new InspectionCertificate();

		try {
			ps = connection.prepareStatement("SELECT * FROM Inspections_certificates ic where ic.driver_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildInspectionSertofocate(rs, inspectionSertificate);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return inspectionSertificate;
	}

	public InspectionCertificate getByDriverId(int id)
			throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		InspectionCertificate inspection = new InspectionCertificate();

		try {
			ps = connection.prepareStatement("SELECT * FROM Inspections_certificates ic where ic.id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildInspectionSertofocate(rs, inspection);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return inspection;
	}

	@Override
	public void update(InspectionCertificate inspection) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Inspections_certificates SET exp_date=?, driver_id=?  WHERE id=?");
			ps.setString(1, inspection.getExDate());
			ps.setLong(2, inspection.getDriverId());
			ps.setLong(3, inspection.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	public void updateByDriverId(InspectionCertificate inspection) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Inspections_certificates SET exp_date=? WHERE driver_id=?");
			ps.setString(1, inspection.getExDate());
			ps.setLong(2, inspection.getDriverId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void delete(InspectionCertificate inspection) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("DELETE FROM Inspections_certificates WHERE id=?");
			ps.setLong(1, inspection.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}
	
	public void deleteByDriverId(InspectionCertificate inspection) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("DELETE FROM Inspections_certificates WHERE driver_id=?");
			ps.setLong(1, inspection.getDriverId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}
	
	@Override
	public List<InspectionCertificate> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		List<InspectionCertificate> listInspectionSertificates = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Inspections_certificates ic ");
			while (rs.next()) {
				InspectionCertificate inspection = new InspectionCertificate();
				buildInspectionSertofocate(rs, inspection);
				listInspectionSertificates.add(inspection);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listInspectionSertificates;
	}

	private void buildInspectionSertofocate(ResultSet rs, InspectionCertificate inspection)
			throws SQLException, ParseException {
		inspection.setId(rs.getLong("ic.id"));
		inspection.setExDate(rs.getString("ic.exp_date"));
		inspection.setDriverId(rs.getInt("ic.driver_id"));
	}
}
