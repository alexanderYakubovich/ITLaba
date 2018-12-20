package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Car;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.ICarDAO;

public class CarMyBatis extends AbstractDao implements ICarDAO {

	public Car getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Car car = null;
		SqlSession session = getSqlSession();
		try {
			car = session.getMapper(ICarDAO.class).getById(id);
		} finally {
			session.close();
		}
		return car;
	}

	@Override
	public void insert(Car entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Car entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Car entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Car> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		List<Car> carlist = null;
		SqlSession session = getSqlSession();
		try {
			carlist = session.getMapper(ICarDAO.class).getAll();
		} finally {
			session.close();
		}
		return carlist;
	}

}
