package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Client;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IClientDAO;

public class ClientMyBatis extends AbstractDao implements IClientDAO{

	@Override
	public Client getById(long id) throws IOException, SQLException, InterruptedException, ParseException {
		Client client = null;
		SqlSession session = getSqlSession();
		try {
			client = session.getMapper(IClientDAO.class).getById(id);
		} finally {
			session.close();
		}
		return client;
	}

	@Override
	public void insert(Client entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Client entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
