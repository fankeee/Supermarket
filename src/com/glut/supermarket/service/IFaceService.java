package com.glut.supermarket.service;

import com.glut.supermarket.bean.User;

public interface IFaceService {
	/**
	 * ��ѯ�ٶȻش���Ϣ�е��û�id�����ݿ����Ƿ��ж�Ӧ���û�
	 * 
	 * @param u_id
	 *            -- �û�id
	 * @param u_name
	 *            -- �û���
	 * @return
	 */
	public User findByIdAndName(int userID, String u_name);
}
