package com.dataOperate;

import java.sql.*;

public class Database {
	private Statement stmt = null;
	ResultSet rs = null;
	private Connection conn = null;
	String sql;
	String driver = "com.mysql.jdbc.Driver";
	String strurl = "jdbc:mysql://127.0.0.1:3306/equipment";
	String user = "root";
	String password = "liuxiaoyi123";
//	String password = "sys406";

	public Database() {

	}

	/**
	 * 打开出数据库连接
	 */
	public void OpenConn() throws Exception {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(strurl, user, password);
		} catch (Exception e) {
			System.err.println("OpenConn:" + e.getMessage());
		}
	}

	/**
	 * 执行sql语句，返回结果集rs
	 */
	public ResultSet executeQuery(String sql) {
		stmt = null;
		rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("executeQuery:" + e.getMessage());
		}
		return rs;

	}

	/**
	 * 执行SQL语句
	 */
	public void executeUpdate(String sql) {
		stmt = null;
		rs = null;

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.executeQuery(sql);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("executeUpdate:" + e.getMessage());
		}

	}

	public void closeStmt() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.err.println("closeStmt:" + e.getMessage());
		}
	}

	/**
	 * 关闭数据连接
	 */
	public void closeConn() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("aq.closeConn:" + e.getMessage());
		}
	}

	public static String toGBK(String str) {
		try {
			if (str == null) {
				str = "";
			} else
				str = new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;

	}

}
