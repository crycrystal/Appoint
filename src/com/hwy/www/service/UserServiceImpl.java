package com.hwy.www.service;

import com.hwy.www.dao.UserDao;
import com.hwy.www.dao.UserDaoImpl;
import com.hwy.www.po.Ui;
import com.hwy.www.po.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	/**
	 * 注册用户
	 */
	@Override
	public boolean regist(User user,Ui ui) {
		// TODO Auto-generated method stub
		//根据学号/工号查询用户对象
		User u1 = userDao.findByUserid(user.getUserid());
		Ui u2 = null;
		
		//判断u是否为null
		if(u1 != null) {
			//该用户id已经存在，注册失败
			return false;
		}
		//用户未存在，注册成功，保存用户信息(包括user表和ui表的信息)
		userDao.save1(u1);
		userDao.save2(u2);
		return true;
	}
	
	/**
	 * 登录方法
	 */
	@Override
	public User login(User user) {
		return userDao.findByUseridAndPassword(user.getUserid(),user.getPassword());
	}
	
}
