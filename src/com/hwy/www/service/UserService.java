package com.hwy.www.service;

import com.hwy.www.po.Ui;
import com.hwy.www.po.User;

public interface UserService {
	
	/**
	 * 注册用户
	 */
	boolean regist(User user,Ui ui);

	User login(User user);

}
