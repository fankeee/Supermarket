package com.glut.supermarket.service;

import com.glut.supermarket.bean.Goods;

public interface IGoodsService {

	/**
	 * ������ƷID��ѯ
	 * 
	 * @param g_id
	 * @return
	 */
	Goods findGoodsById(int g_id);

}
