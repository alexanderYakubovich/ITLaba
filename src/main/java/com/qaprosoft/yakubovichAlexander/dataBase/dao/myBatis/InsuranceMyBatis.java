package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Insurance;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IInsuranceDAO;

public class InsuranceMyBatis extends AbstractDao implements IInsuranceDAO {

	@Override
	public Insurance getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Insurance insurance = null;
		SqlSession session = getSqlSession();
		try {
			insurance = session.getMapper(IInsuranceDAO.class).getById(id);
		} finally {
			session.close();
		}
		return insurance;
	}

	@Override
	public void insert(Insurance entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Insurance entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Insurance entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Insurance> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
