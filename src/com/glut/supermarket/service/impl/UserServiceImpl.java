package com.glut.supermarket.service.impl;

import com.glut.supermarket.bean.User;
import com.glut.supermarket.dao.IUserDao;
import com.glut.supermarket.dao.impl.UserDaoImpl;
import com.glut.supermarket.service.IUserService;

/**
 * 用户业务实现类
 * 
 * @author Fk
 *
 */
public class UserServiceImpl implements IUserService {

	@Override
	public Boolean checkUserID(int userID) {
		// TODO Auto-generated method stub
		IUserDao userDao = new UserDaoImpl();
		Boolean result = userDao.findUserById(userID);
		return result;
	}

	@Override
	public User accountLogin(int userID, String pwd) {
		// TODO Auto-generated method stub
		IUserDao userDao = new UserDaoImpl();
		User user = userDao.findByIdAndPwd(userID, pwd);

		return user;
	}

}
