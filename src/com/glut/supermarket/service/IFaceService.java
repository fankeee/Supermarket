package com.glut.supermarket.service;

import com.glut.supermarket.bean.User;

public interface IFaceService {
	/**
	 * 查询百度回传信息中的用户id在数据库中是否有对应的用户
	 * 
	 * @param u_id
	 *            -- 用户id
	 * @param u_name
	 *            -- 用户名
	 * @return
	 */
	public User findByIdAndName(int userID, String u_name);
}
