package com.glut.supermarket.dao;

import com.glut.supermarket.bean.User;

/**
 * 用户接口DAO
 * 
 * @author Fk
 *
 */
public interface IUserDao {

	/**
	 * 根据用户ID查询
	 * 
	 * @param userID
	 *            用户ID
	 * @return
	 */
	Boolean findUserById(int userID);

	/**
	 * 根据用户ID和密码查询
	 * 
	 * @param userID
	 *            用户ID
	 * @param pwd
	 *            用户密码
	 * @return
	 */
	User findByIdAndPwd(int userID, String pwd);

}
