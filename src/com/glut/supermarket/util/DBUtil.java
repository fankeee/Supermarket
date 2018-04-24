package com.glut.supermarket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	// ��ȡ����
	public static Connection getConn() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ����
		String driver = "com.mysql.jdbc.Driver";
		// ���ݿ���
		String dbName = "supermarket";
		// �û���
		String userName = "root";
		// ����
		String userPwd = "950526";

		String url1 = "jdbc:mysql://localhost:3306/" + dbName;
		String url2 = "?user=" + userName + "&password=" + userPwd;
		String url3 = "&useUnicode = true&characterEncoding=UTF-8";
		String url = url1 + url2 + url3;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// �ͷ���Դ
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
