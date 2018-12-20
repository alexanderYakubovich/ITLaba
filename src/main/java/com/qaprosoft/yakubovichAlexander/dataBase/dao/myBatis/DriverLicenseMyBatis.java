package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.DriverLicense;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IDriverLicenseDAO;

public class DriverLicenseMyBatis extends AbstractDao implements IDriverLicenseDAO {

	@Override
	public DriverLicense getById(long id) throws IOException, SQLException, InterruptedException, ParseException {
		DriverLicense driverLicense = null;
		SqlSession session = getSqlSession();
		try {
			driverLicense = session.getMapper(IDriverLicenseDAO.class).getById(id);
		} finally {
			session.close();
		}
		return driverLicense;
	}

	@Override
	public void insert(DriverLicense entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(DriverLicense entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DriverLicense entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DriverLicense> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
