package com.glut.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.glut.supermarket.bean.Goods;
import com.glut.supermarket.dao.IGoodsDao;
import com.glut.supermarket.util.JNDI;

public class GoodsDaoImpl implements IGoodsDao {

	@Override
	public Goods findGoodsById(int g_id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// ��ȡ����
			conn = JNDI.getConn();
			// System.out.println("========���ݿ�����conn========"+conn);

			// ����SQL���
			String sql = "select * from t_goods where g_id=?";

			ps = conn.prepareStatement(sql);
			// �����ʺŴ�ֵ

			ps.setInt(1, g_id);

			// ִ�в�ѯ
			rs = ps.executeQuery();
			// ��������
			if (rs.next()) {
				int pro_id = rs.getInt("Pro_id");
				int c_id = rs.getInt("C_id");
				String g_name = rs.getString("G_name");
				float g_purchasePrice = rs.getFloat("G_purchasePrice");
				float g_sellingPrice = rs.getFloat("G_sellingPrice");
				String g_unit = rs.getString("G_unit");
				Date g_productionDate = new Date(rs.getDate("G_productionDate").getTime());
				String g_shelfLife = rs.getString("G_shelfLife");
				int g_inventory = rs.getInt("G_inventory");
				String g_productionAddress = rs.getString("G_productionAddress");
				Goods goods = new Goods(g_id, g_name, g_purchasePrice, g_sellingPrice, g_unit, g_productionDate,
						g_shelfLife, g_inventory, pro_id, g_productionAddress, c_id);
				System.out.println("goods-------->>>" + goods);
				return goods;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JNDI.close(conn, ps, rs);
		}
		return null;
	}

}
