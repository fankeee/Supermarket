package com.glut.supermarket.dao;

import com.glut.supermarket.bean.User;

/**
 * 人脸接口DAO
 * 
 * @author Fk
 *
 */
public interface IFaceDao {
	/**
	 * 根据用户id和用户名查询该用户是否存在
	 * 
	 * @param u_id
	 *            -- 用户id
	 * @param u_name
	 *            -- 用户名
	 * @return
	 */
	public User findByIdAndName(int userID, String u_name);
}
