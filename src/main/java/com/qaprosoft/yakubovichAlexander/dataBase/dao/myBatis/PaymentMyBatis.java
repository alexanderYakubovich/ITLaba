package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Payment;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IPaymentDAO;

public class PaymentMyBatis extends AbstractDao implements IPaymentDAO {

	@Override
	public Payment getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Payment payment = null;
		SqlSession session = getSqlSession();
		try {
			payment = session.getMapper(IPaymentDAO.class).getById(id);
		} finally {
			session.close();
		}
		return payment;
	}

	@Override
	public void insert(Payment entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Payment entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Payment entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Payment> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
