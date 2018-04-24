package com.glut.supermarket.dao;

import com.glut.supermarket.bean.User;

/**
 * �û��ӿ�DAO
 * 
 * @author Fk
 *
 */
public interface IUserDao {

	/**
	 * �����û�ID��ѯ
	 * 
	 * @param userID
	 *            �û�ID
	 * @return
	 */
	Boolean findUserById(int userID);

	/**
	 * �����û�ID�������ѯ
	 * 
	 * @param userID
	 *            �û�ID
	 * @param pwd
	 *            �û�����
	 * @return
	 */
	User findByIdAndPwd(int userID, String pwd);

}
