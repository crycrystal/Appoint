package com.hwy.www.dao;

import com.hwy.www.po.Ui;
import com.hwy.www.po.User;

public interface UserDao {
	
	/**
	 * 根据学号/工号查询用户信息
	 */
	public User findByUserid(String userid);
	
	/**
	 * 用户保存，添加新用户
	 */
	public void save1(User user);
	public void save2(Ui ui);

	public User findByUseridAndPassword(String userid, String password);
}
