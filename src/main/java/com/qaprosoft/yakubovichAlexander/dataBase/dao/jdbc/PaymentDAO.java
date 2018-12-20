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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Payment;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IPaymentDAO;


public class PaymentDAO extends AbstractDao implements IPaymentDAO {
	private static final Logger LOGGER = LogManager.getLogger(PaymentDAO.class);

	@Override
	public void insert(Payment pay) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Payments (type,order_id) VALUES (?,?)");
			ps.setString(1, pay.getType());
			ps.setLong(2, pay.getOrderId());
			ps.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void update(Payment pay) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Payments SET type=?, order_id=? WHERE id=?");
			ps.setString(1, pay.getType());
			ps.setLong(2, pay.getOrderId());
			ps.setLong(3, pay.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public Payment getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Payment pay = new Payment();

		try {
			ps = connection.prepareStatement("SELECT * FROM Payments p where p.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildPayment(rs, pay);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return pay;
	}

	public Payment getByOrderId(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Payment pay = new Payment();

		try {
			ps = connection.prepareStatement("SELECT * FROM Payments p where p.order_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildPayment(rs, pay);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return pay;
	}

	
	@Override
	public void delete(Payment pay) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Payments WHERE id=?");
			ps.setLong(1, pay.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<Payment> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Payment> listPayments = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Payments p");
			while (rs.next()) {
				Payment pay = new Payment();
				buildPayment(rs, pay);
				listPayments.add(pay);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();

		}
		return listPayments;
	}

	private void buildPayment(ResultSet rs, Payment pay) throws SQLException {
		pay.setType(rs.getString("p.type"));
		pay.setId(rs.getLong("p.id"));
		pay.setOrderId(rs.getInt("p.order_id"));
	}

}
