package com.glut.supermarket.dao;

import com.glut.supermarket.bean.Goods;

/**
 * 商品接口DAO
 * 
 * @author Fk
 *
 */
public interface IGoodsDao {

	/**
	 * 根据商品ID查询
	 * 
	 * @param g_id
	 * @return
	 */
	Goods findGoodsById(int g_id);

}
