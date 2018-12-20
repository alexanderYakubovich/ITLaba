package com.qaprosoft.yakubovichAlexander.pool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionPool {

	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool INSTANCE;
	private static int SIZE = 5;
	private static BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(SIZE);
	private static int countConnection;
	private String url;
	private String username;
	private String password;
	private Properties props;
	private Connection connection = null;
	
	private ConnectionPool() {
		props = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream("src/main/resources/database.properties");
		} catch (FileNotFoundException e2) {
			LOGGER.error(e2.getMessage());
		}
		try {
			props.load(in);
		} catch (IOException e2) {
			LOGGER.error(e2.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e3) {
				LOGGER.error(e3.getMessage());
			}
		}
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
	}

	private Connection createConnection() throws SQLException, IOException {
		 
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return connection;
	}

	public static ConnectionPool getINSTANCE() {
		Lock l = new ReentrantLock();
		l.lock();
		try {
			if (INSTANCE == null) {
				INSTANCE = new ConnectionPool();
			}
		} finally {
			l.unlock();
		}
		return INSTANCE;
	}

	public Connection getConnection() throws InterruptedException, SQLException, IOException {
		Lock l = new ReentrantLock();
		l.lock();
		if (pool.isEmpty() && countConnection < SIZE) {
			pool.put(createConnection());
			countConnection++;
			LOGGER.info("Count connection = " + countConnection);
		}
		l.unlock();	
		Connection connection = pool.take();
		return connection;
	}

	public void putBackConnection(Connection connection) {
		pool.add(connection);
	}
}
