package com.glut.supermarket.service;

import com.glut.supermarket.bean.User;

/**
 * �û�ҵ��ӿ�
 * 
 * @author Fk
 *
 */
public interface IUserService {

	/**
	 * ����û����Ƿ����
	 * 
	 * @param username  
	 * @return
	 */
	public Boolean checkUserID(int userID);

	/**
	 * �˺ŵ�¼
	 * 
	 * @param userID
	 * @param pwd
	 * @return
	 */
	public User accountLogin(int userID, String pwd);
}
