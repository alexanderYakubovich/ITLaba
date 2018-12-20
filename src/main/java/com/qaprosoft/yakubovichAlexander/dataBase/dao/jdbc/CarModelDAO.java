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
import com.qaprosoft.yakubovichAlexander.dataBase.entity.CarModel;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.ICarModelDAO;


public class CarModelDAO extends AbstractDao implements ICarModelDAO {

	private static final Logger LOGGER = LogManager.getLogger(CarModelDAO.class);

	@Override
	public void insert(CarModel carModel) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("INSERT INTO  Cars_models (color,model,number) VALUES (?,?,?)");
			ps.setString(1, carModel.getColor());
			ps.setString(2, carModel.getModel());
			ps.setString(3, carModel.getNumber());
			ps.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public CarModel getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		CarModel carModel = new CarModel();

		try {
			ps = connection.prepareStatement("SELECT * FROM Cars_models cm where cm.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCarModel(rs, carModel);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
			rs.close();
		}
		return carModel;
	}

	@Override
	public void update(CarModel carModel) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("UPDATE Cars_models SET color=?, model=?, number=?  WHERE id=?");
			ps.setString(1, carModel.getColor());
			ps.setString(2, carModel.getModel());
			ps.setString(3, carModel.getNumber());
			ps.setLong(4, carModel.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public void delete(CarModel carModel) throws SQLException, IOException, InterruptedException {
		Connection connection = POOL.getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("DELETE FROM Cars_models WHERE id=?");
			ps.setLong(1, carModel.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			ps.close();
		}
	}

	@Override
	public List<CarModel> getAll() throws SQLException, ParseException, IOException, InterruptedException {

		Connection connection = POOL.getConnection();
		List<CarModel> listCarModels = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Cars_models cm");
			while (rs.next()) {
				CarModel carModel = new CarModel();
				buildCarModel(rs, carModel);
				listCarModels.add(carModel);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			POOL.putBackConnection(connection);
			st.close();
			rs.close();
		}
		return listCarModels;
	}

	private void buildCarModel(ResultSet rs, CarModel carModel) throws SQLException {
		carModel.setId(rs.getLong("cm.id"));
		carModel.setColor(rs.getString("cm.color"));
		carModel.setModel(rs.getString("cm.model"));
		carModel.setNumber(rs.getString("cm.number"));
	}
}
