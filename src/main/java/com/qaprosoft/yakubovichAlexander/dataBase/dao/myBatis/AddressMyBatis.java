package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Address;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IAddressDAO;

public class AddressMyBatis extends AbstractDao implements IAddressDAO {

	@Override
	public Address getById(long id) throws IOException, SQLException, InterruptedException, ParseException {
		Address address = null;
		SqlSession session = getSqlSession();
		try {
		address = session.getMapper(IAddressDAO.class).getById(id);
		} finally {
			session.close();
		}
		return address;
	}

	@Override
	public void insert(Address entity) throws SQLException, IOException, InterruptedException {
	}

	@Override
	public void update(Address entity) throws SQLException, IOException, InterruptedException {
	}

	@Override
	public void delete(Address entity) throws SQLException, IOException, InterruptedException {
	}

	@Override
	public List<Address> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		return null;
	}
}