package com.glut.supermarket.service.impl;

import com.glut.supermarket.bean.User;
import com.glut.supermarket.dao.IFaceDao;
import com.glut.supermarket.dao.impl.FaceDaoImpl;
import com.glut.supermarket.service.IFaceService;

public class FaceServiceImpl implements IFaceService {

	@Override
	public User findByIdAndName(int u_id, String u_name) {
		IFaceDao faceDao = new FaceDaoImpl();
		
		return faceDao.findByIdAndName(u_id, u_name);
	}

	

}
