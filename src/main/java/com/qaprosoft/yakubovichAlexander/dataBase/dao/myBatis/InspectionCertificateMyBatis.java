package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.InspectionCertificate;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IInspectionCertificateDAO;

public class InspectionCertificateMyBatis extends AbstractDao implements IInspectionCertificateDAO {

	@Override
	public InspectionCertificate getById(long id)
			throws IOException, SQLException, InterruptedException, ParseException {
		InspectionCertificate inspectionCertificate = null;
		SqlSession session = getSqlSession();
		try {
			inspectionCertificate = session.getMapper(IInspectionCertificateDAO.class).getById(id);
		} finally {
			session.close();
		}
		return inspectionCertificate;
	}

	@Override
	public void insert(InspectionCertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(InspectionCertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(InspectionCertificate entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<InspectionCertificate> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
