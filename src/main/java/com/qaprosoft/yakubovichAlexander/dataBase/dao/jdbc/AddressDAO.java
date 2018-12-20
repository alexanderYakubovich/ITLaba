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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Address;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IAddressDAO;

public class AddressDAO extends AbstractDao implements IAddressDAO {
	private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

	@Override
	public void insert(Address address) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("INSERT INTO  Addresses (street,number_home) VALUES (?,?)");
			ps.setString(1, address.getStreet());
			ps.setInt(2, address.getNumberHome());
			ps.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void update(Address address) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Addresses SET street=?, number_home=? WHERE id=?");
			ps.setString(1, address.getStreet());
			ps.setInt(2, address.getNumberHome());
			ps.setLong(3, address.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public Address getById(long id) throws InterruptedException, SQLException, IOException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;
		Address address = new Address();
		try {
			ps = connection.prepareStatement("SELECT * FROM Addresses a where a.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildAddress(rs, address);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return address;
	}



	@Override
	public void delete(Address address) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM Addresses WHERE id=?");
			ps.setLong(1, address.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<Address> getAll() throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();

		List<Address> listAddresses = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Addresses a");
			while (rs.next()) {
				Address address = new Address();
				buildAddress(rs, address);
				listAddresses.add(address);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();

		}
		return listAddresses;
	}

	private void buildAddress(ResultSet rs, Address address) throws SQLException {
		address.setStreet(rs.getString("a.street"));
		address.setNumberHome(rs.getInt("a.number_home"));
		address.setId(rs.getInt("a.id"));
	}
}
