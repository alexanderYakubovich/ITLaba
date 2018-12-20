package com.qaprosoft.yakubovichAlexander.jdbcConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionJDBC {
	private static final Logger LOGGER = LogManager.getLogger(ConnectionJDBC.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = createConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Users");

			while (rs.next()) {
				String name = rs.getString("name");
				Double rating = rs.getDouble("rating");
				String numberPhone = rs.getString("number_phone");
				LOGGER.info(name + "\t" + "\t" + rating + "\t" + numberPhone);
			}
		} finally {
			st.close();
		}
	}

	public static Connection createConnection() {

		Properties props = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream("src/main/resources/jdbc/database.properties");
		} catch (FileNotFoundException e2) {
			LOGGER.error(e2);
		}
		try {
			props.load(in);
		} catch (IOException e1) {
			LOGGER.error("Props didn't load", e1);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}

		String driver = props.getProperty("driver");
		if (driver != null) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				LOGGER.error("Driver equals null", e);
			}
		}
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Connect");
		return conn;
	}

}
