package com.rs.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rs.exception.RechargeSystemException;

import oracle.jdbc.pool.OracleDataSource;

/**
 * @author gowthc
 *
 */
public class DBConnection {
	
	private static Properties properties= new Properties();
	private static Connection connection;
	static Logger logger=Logger.getRootLogger();
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	public static Connection getConnection() throws RechargeSystemException{
		
		try {
			InputStream inputStream =new FileInputStream("resources/jdbc.properties");
			properties.load(inputStream);
			String url=properties.getProperty("dburl");
			String user=properties.getProperty("username");
			String password=properties.getProperty("password");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (FileNotFoundException e2) {
			logger.error(e2);
			throw new RechargeSystemException("Could not Find properties file to connect to database.");
		} catch (IOException e) {
			logger.error(e);
			throw new RechargeSystemException("Could not read the database details from properties file.");
		} catch (SQLException e) {
			logger.error(e);
			throw new RechargeSystemException("Database connection problem.");
		}
		
		return connection;
	
	}
}
