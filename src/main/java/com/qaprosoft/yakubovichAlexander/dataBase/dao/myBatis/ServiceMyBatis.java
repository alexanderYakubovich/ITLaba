package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Service;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IServiceDAO;

public class ServiceMyBatis extends AbstractDao implements IServiceDAO {

	@Override
	public Service getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Service service = null;
		SqlSession session = getSqlSession();
		try {
			service = session.getMapper(IServiceDAO.class).getById(id);
		} finally {
			session.close();
		}
		return service;
	}

	@Override
	public void insert(Service entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Service entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Service entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Service> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		List<Service> service = null;
		SqlSession session = getSqlSession();
		try {
			service = session.getMapper(IServiceDAO.class).getAll();
		} finally {
			session.close();
		}
		return service;
	}
}