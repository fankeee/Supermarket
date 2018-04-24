package com.glut.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.glut.supermarket.bean.User;
import com.glut.supermarket.dao.IFaceDao;
import com.glut.supermarket.util.JNDI;

public class FaceDaoImpl implements IFaceDao {

	@Override
	public User findByIdAndName(int userID, String u_name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// ��ȡ����
			conn = JNDI.getConn();

			// ����SQL���
			String sql = "select * from t_user where u_id=? and u_name=?";

			ps = conn.prepareStatement(sql);
			// �����ʺŴ�ֵ

			ps.setInt(1, userID);
			ps.setString(2, u_name);

			// ִ�в�ѯ
			rs = ps.executeQuery();
			// ��������
			if (rs.next()) {
				// �û�����
				String u_pwd = rs.getString("u_pwd");
				// �û�����
				// String u_name = rs.getString("u_name");
				// �û�����
				int u_age = rs.getInt("u_age");
				// �û��Ա�
				String u_sex = rs.getString("u_sex");
				// �û��绰
				String u_tel = rs.getString("u_tel");

				User user = new User(userID, u_pwd, u_name, u_age, u_sex, u_tel);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JNDI.close(conn, ps, rs);
		}
		return null;
	}

}
