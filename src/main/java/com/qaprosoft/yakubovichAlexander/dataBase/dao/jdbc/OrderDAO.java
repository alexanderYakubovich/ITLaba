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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Order;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IOrderDAO;


public class OrderDAO extends AbstractDao implements IOrderDAO {
	private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

	@Override
	public void insert(Order order) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(
					"INSERT INTO  Orders (cost,client_id, address_departure_id, address_arrival_id ) VALUES (?,?,?,?)");
			ps.setDouble(1, order.getCost());
			ps.setLong(2, order.getClientId());
			ps.setLong(3, order.getAddressDepartureId());
			ps.setLong(4, order.getAddressArriveId());
			ps.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void update(Order order) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(
					"UPDATE Orders SET cost=?, client_id=?, address_departure_id=?, address_arrival_id=? WHERE id=?");
			ps.setDouble(1, order.getCost());
			ps.setLong(2, order.getClientId());
			ps.setLong(3, order.getAddressDepartureId());
			ps.setLong(4, order.getAddressArriveId());
			ps.setLong(5, order.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public Order getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order = new Order();

		try {
			ps = connection.prepareStatement("SELECT * FROM Orders o where o.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildOrder(rs, order);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return order;
	}
	
	public Order getByClientId(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order = new Order();

		try {
			ps = connection.prepareStatement("SELECT * FROM Orders o LEFT JOIN Client c ON o.client_id = c.id where o.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildOrder(rs, order);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return order;
	}
	


	@Override
	public void delete(Order order) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Orders WHERE id=?");
			ps.setLong(1, order.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<Order> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Order> listOrders = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Orders o");
			while (rs.next()) {
				Order order = new Order();
				buildOrder(rs, order);
				listOrders.add(order);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();

		}
		return listOrders;
	}

	private void buildOrder(ResultSet rs, Order order) throws SQLException {
		order.setId(rs.getLong("o.id"));
		order.setCost(rs.getDouble("o.cost"));
		order.setClientId(rs.getInt("o.client_id"));
		order.setAddressDepartureId(rs.getInt("o.address_departure_id"));
		order.setAddressArriveId(rs.getInt("o.address_arrival_id"));
	}

}
