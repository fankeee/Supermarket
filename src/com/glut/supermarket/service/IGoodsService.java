package com.glut.supermarket.service;

import com.glut.supermarket.bean.Goods;

public interface IGoodsService {

	/**
	 * 根据商品ID查询
	 * 
	 * @param g_id
	 * @return
	 */
	Goods findGoodsById(int g_id);

}
