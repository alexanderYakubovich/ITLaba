package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Order;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IOrderDAO;

public class OrderMyBatis extends AbstractDao implements IOrderDAO {

	@Override
	public Order getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Order order = null;
		SqlSession session = getSqlSession();
		try {
			order = session.getMapper(IOrderDAO.class).getById(id);
		} finally {
			session.close();
		}
		return order;
	}

	@Override
	public void insert(Order entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Order entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Order entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
