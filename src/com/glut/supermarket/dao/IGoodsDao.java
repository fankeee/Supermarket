package com.glut.supermarket.dao;

import com.glut.supermarket.bean.Goods;

/**
 * ��Ʒ�ӿ�DAO
 * 
 * @author Fk
 *
 */
public interface IGoodsDao {

	/**
	 * ������ƷID��ѯ
	 * 
	 * @param g_id
	 * @return
	 */
	Goods findGoodsById(int g_id);

}
