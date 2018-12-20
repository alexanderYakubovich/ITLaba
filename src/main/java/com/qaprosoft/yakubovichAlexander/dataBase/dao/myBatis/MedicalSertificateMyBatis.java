package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.MedicalSertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IMedicalSertificateDAO;

public class MedicalSertificateMyBatis extends AbstractDao implements IMedicalSertificateDAO {

	@Override
	public MedicalSertificate getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		MedicalSertificate medicalSertificate = null;
		SqlSession session = getSqlSession();
		try {
			medicalSertificate = session.getMapper(IMedicalSertificateDAO.class).getById(id);
		} finally {
			session.close();
		}
		return medicalSertificate;
	}

	@Override
	public void insert(MedicalSertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MedicalSertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MedicalSertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MedicalSertificate> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
