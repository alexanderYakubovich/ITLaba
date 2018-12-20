package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Driver;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IDriverDAO;

public class DriverMyBatis extends AbstractDao implements IDriverDAO {

	@Override
	public void insert(Driver entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Driver entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Driver entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Driver> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getById(long id) throws SQLException, ParseException, IOException, InterruptedException {
		Driver driver = null;
		SqlSession session = getSqlSession();
		try {
			driver = session.getMapper(IDriverDAO.class).getById(id);
		} finally {
			session.close();
		}
		return driver;
	}

}
