package com.qaprosoft.yakubovichAlexander.dataBase.dao.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qaprosoft.yakubovichAlexander.dataBase.dao.AbstractDao;
import com.qaprosoft.yakubovichAlexander.dataBase.entity.Route;
import com.qaprosoft.yakubovichAlexander.dataBase.interfaces.IRouteDAO;

public class RouteMyBatis extends AbstractDao implements IRouteDAO {

	@Override
	public Route getByOrderId(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Route route = null;
		SqlSession session = getSqlSession();
		try {
			route = session.getMapper(IRouteDAO.class).getById(id);
		} finally {
			session.close();
		}
		return route;
	}

	public Route getById(long id) throws IOException, SQLException, InterruptedException, ParseException {

		Route route = null;
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();

		try {
			IRouteDAO routeDAO = session.getMapper(IRouteDAO.class);
			route = routeDAO.getById(id);
		} finally {
			session.close();
		}
		return route;
	}

	@Override
	public void insert(Route entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Route entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Route entity) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Route> getAll() throws SQLException, ParseException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
