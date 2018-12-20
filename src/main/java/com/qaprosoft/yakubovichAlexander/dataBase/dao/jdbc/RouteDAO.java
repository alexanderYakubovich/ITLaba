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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Route;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IRouteDAO;


public class RouteDAO extends AbstractDao implements IRouteDAO {
	private static final Logger LOGGER = LogManager.getLogger(RouteDAO.class);

	@Override
	public void insert(Route route) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Routes (distance,time, order_id) VALUES (?,?,?)");
			ps.setInt(1, route.getDistance());
			ps.setInt(2, route.getTime());
			ps.setLong(3, route.getOrderId());
			ps.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void update(Route route) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Routes SET distance=?, time=?, order_id=? WHERE id=?");
			ps.setInt(1, route.getDistance());
			ps.setInt(2, route.getTime());
			ps.setLong(3, route.getOrderId());
			ps.setLong(4, route.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public Route getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Route route = new Route();

		try {
			ps = connection.prepareStatement("SELECT * FROM Routes r where r.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildRoute(rs, route);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return route;
	}

	public Route getByOrderId(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Route route = new Route();

		try {
			ps = connection.prepareStatement("SELECT * FROM Routes r where r.order_id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildRoute(rs, route);

			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return route;
	}
	
	@Override
	public void delete(Route route) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Routes WHERE id=?");
			ps.setLong(1, route.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<Route> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Route> listRoutes = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Routes r");
			while (rs.next()) {
				Route route = new Route();
				buildRoute(rs, route);
				listRoutes.add(route);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();

		}
		return listRoutes;
	}

	private void buildRoute(ResultSet rs, Route route) throws SQLException {
		route.setDistance(rs.getInt("r.distance"));
		route.setTime(rs.getInt("r.time"));
		route.setOrderId(rs.getInt("r.order_id"));
		route.setId(rs.getLong("r.id"));
	}
}
