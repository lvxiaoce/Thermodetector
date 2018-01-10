package com.kun.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static String dbUrl="jdbc:mysql://localhost:3306/thermodetector";
	private static String dbUsername="root";
	private static String dbPassword="root";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception{
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		return conn;
		
	}
	
	public static void closeConn(Connection conn) throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			DbUtil.getConn();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
