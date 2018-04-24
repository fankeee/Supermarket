package com.glut.supermarket.service.impl;

import com.glut.supermarket.bean.Goods;
import com.glut.supermarket.dao.IGoodsDao;
import com.glut.supermarket.dao.impl.GoodsDaoImpl;
import com.glut.supermarket.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {

	@Override
	public Goods findGoodsById(int g_id) {
		// TODO Auto-generated method stub

		IGoodsDao goodsDao = new GoodsDaoImpl();
		// System.out.println("GoodsServiceImpl--->>>"+g_id);
		return goodsDao.findGoodsById(g_id);
	}

}
