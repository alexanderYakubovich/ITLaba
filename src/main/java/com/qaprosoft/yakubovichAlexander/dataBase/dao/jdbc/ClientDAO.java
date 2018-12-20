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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Client;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IClientDAO;


public class ClientDAO extends AbstractDao implements IClientDAO {
	private static final Logger LOGGER = LogManager.getLogger(ClientDAO.class);

	@Override
	public void insert(Client client) throws SQLException, IOException, InterruptedException {

		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Users (name,rating,number_phone) VALUES (?,?,?)");
			ps.setString(1, client.getName());
			ps.setDouble(2, client.getRating());
			ps.setString(3, client.getNumberPhone());
			ps.executeUpdate();

			ps1 = connection.prepareStatement("INSERT INTO  Clients (id,user_cl_id) VALUES (?,?)");
			ps1.setLong(1, client.getId());
			ps1.setLong(2, client.getUserClId());

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
	public void update(Client client) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {
			ps = connection.prepareStatement("UPDATE Users SET name=?, rating=?, number_Phone=? WHERE id=?");
			ps.setString(1, client.getName());
			ps.setDouble(2, client.getRating());
			ps.setString(3, client.getNumberPhone());
			ps.setLong(4, client.getId());
			ps.executeUpdate();

			ps1 = connection.prepareStatement("UPDATE Clients SET user_cl_id=? WHERE id=?");
			ps1.setLong(1, client.getUserClId());
			ps1.setLong(2, client.getId());

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
	public Client getById(long id) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client client = new Client();
		try {
			ps = connection.prepareStatement(
					"SELECT * FROM Clients c LEFT JOIN Users u ON u.id = c.user_cl_id where c.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildClient(rs, client);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return client;
	}

	
	@Override
	public void delete(Client client) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			ps1 = connection.prepareStatement("DELETE FROM Clients WHERE id=?");
			ps1.setLong(1, client.getId());
			ps1.executeUpdate();

			ps2 = connection.prepareStatement("DELETE FROM  Users WHERE id=?");
			ps2.setLong(1, client.getId());
			ps2.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps1.close();
			ps2.close();
		}
	}

	@Override
	public List<Client> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		List<Client> listClients = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Clients c" + " LEFT JOIN Users u ON c.user_cl_id = u.id");
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getLong("u.id"));
				buildClient(rs, client);
				client.setId(rs.getLong("c.id"));
				listClients.add(client);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listClients;
	}

	private void buildClient(ResultSet rs, Client client) throws SQLException {
		client.setName(rs.getString("u.name"));
		client.setRating(rs.getDouble("u.rating"));
		client.setNumberPhone(rs.getString("u.number_phone"));
		client.setUserClId(rs.getInt("c.user_cl_id"));
		client.setId(rs.getInt("c.id"));

	}

}
