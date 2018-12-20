package com.qaprosoft.yakubovichAlexander.dataBase.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.pool.ConnectionPool;

public abstract class AbstractDao {

	private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);

	protected static final ConnectionPool POOL = ConnectionPool.getINSTANCE();

	protected static SqlSession getSqlSession() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
		return session;
	}
}