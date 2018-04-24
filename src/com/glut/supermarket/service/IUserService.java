package com.glut.supermarket.service;

import com.glut.supermarket.bean.User;

/**
 * 用户业务接口
 * 
 * @author Fk
 *
 */
public interface IUserService {

	/**
	 * 检查用户名是否存在
	 * 
	 * @param username  
	 * @return
	 */
	public Boolean checkUserID(int userID);

	/**
	 * 账号登录
	 * 
	 * @param userID
	 * @param pwd
	 * @return
	 */
	public User accountLogin(int userID, String pwd);
}
