package com.glut.supermarket.dao;

import com.glut.supermarket.bean.User;

/**
 * �����ӿ�DAO
 * 
 * @author Fk
 *
 */
public interface IFaceDao {
	/**
	 * �����û�id���û�����ѯ���û��Ƿ����
	 * 
	 * @param u_id
	 *            -- �û�id
	 * @param u_name
	 *            -- �û���
	 * @return
	 */
	public User findByIdAndName(int userID, String u_name);
}
