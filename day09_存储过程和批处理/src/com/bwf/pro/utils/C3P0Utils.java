package com.bwf.pro.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	private static ComboPooledDataSource dataSource;
	
	static {
		dataSource =new ComboPooledDataSource();
	}
	
	
	/**
	 * ��ȡһ������
	 */
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	
	
	/**
	 * �ر����ݿ�����
	 */
	public static void cloasJDBC(Connection connection){
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public static void cloasJDBC(Connection connection,PreparedStatement statement){
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void cloasJDBC(Connection connection,PreparedStatement statement,ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
