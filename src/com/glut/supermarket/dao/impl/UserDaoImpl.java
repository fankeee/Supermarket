package com.glut.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.glut.supermarket.bean.User;
import com.glut.supermarket.dao.IUserDao;
import com.glut.supermarket.util.JNDI;

public class UserDaoImpl implements IUserDao {

	@Override
	public Boolean findUserById(int userID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 获取连接
			conn = JNDI.getConn();
			// System.out.println("========数据库连接conn========"+conn);

			// 创建SQL语句
			String sql = "select * from t_user where u_id=?";

			ps = conn.prepareStatement(sql);
			// 处理问号传值

			ps.setInt(1, userID);

			// 执行查询
			rs = ps.executeQuery();
			// 处理结果集
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JNDI.close(conn, ps, rs);
		}
		return false;
	}

	@Override
	public User findByIdAndPwd(int userID, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 获取连接
			conn = JNDI.getConn();

			// 创建SQL语句
			String sql = "select * from t_user where u_id=? and u_pwd=?";

			ps = conn.prepareStatement(sql);
			// 处理问号传值

			ps.setInt(1, userID);
			ps.setString(2, pwd);

			// 执行查询
			rs = ps.executeQuery();
			// 处理结果集
			if (rs.next()) {

				// 用户密码
				String u_pwd = rs.getString("u_pwd");
				// 用户姓名
				String u_name = rs.getString("u_name");
				// 用户年龄
				int u_age = rs.getInt("u_age");
				// 用户性别
				String u_sex = rs.getString("u_sex");
				// 用户电话
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
