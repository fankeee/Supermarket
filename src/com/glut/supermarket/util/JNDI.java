package com.glut.supermarket.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDI {
	// ��ȡ����
	public static Connection getConn() {
		Connection connection = null;
		try {
			Context ctx = new InitialContext();
			// ��ȡ���߼��������������Դ����
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			connection = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
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

	// ������ɾ��ͨ�����
	public static boolean commom(String sql, Object... obj) {
		// 1������ӿ�
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = JNDI.getConn();
			ps = conn.prepareStatement(sql);
			// �����ʺŴ�ֵ
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			// ִ��sql
			int num = ps.executeUpdate();
			if (num > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
