package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.CarModel;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.ICarModelDAO;

public class CarModelMyBatis extends AbstractDao implements ICarModelDAO {

	@Override
	public CarModel getById(long id) throws IOException, SQLException, InterruptedException, ParseException {
		CarModel carModel = null;
		SqlSession session = getSqlSession();
		try {
			carModel = session.getMapper(ICarModelDAO.class).getById(id);
		} finally {
			session.close();
		}
		return carModel;
	}

	

	@Override
	public void insert(CarModel entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CarModel entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CarModel entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CarModel> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
