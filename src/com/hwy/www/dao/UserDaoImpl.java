package com.hwy.www.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hwy.www.po.Ui;
import com.hwy.www.po.User;
import com.hwy.www.util.JDBCUtils;

public class UserDaoImpl implements UserDao {

	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	/**
	 * 根据用户id查询的方法（注册）
	 */
	@Override
	public User findByUserid(String userid) {
		//执行SQL
		User user = null;
		try {
			// TODO Auto-generated method stub
			//定义SQL：查询用户id是否已经存在,不存在才能成功注册
			//若没有查询到记录（即封装失败）时不会返回null，故需要try-catch捕获异常
			String sql = "select * from user where userid = ?";
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public void save1(User user) {
		// TODO Auto-generated method stub
		//定义SQL：获得用户(user)表中的数据
		String sql = "insert into user (userid,password,username,number,institute) values(?,?,?,?,?)";
		//执行SQL
		template.update(sql,
				user.getUserid(),
				user.getPassword(),
				user.getUsername(),
				user.getNumber(),
				user.getInstitude());
	}

	@Override
	public void save2(Ui ui) {
		// TODO Auto-generated method stub
		//定义SQL：获得用户角色(ui)表中的数据
		String sql = "insert into ui (uid,code) values(?,?)";
		//执行SQL
		template.update(sql,
				ui.getUid(),
				ui.getCode());
		
	}

	/**
	 * 根据用户id和密码查询的方法（登录）
	 */
	@Override
	public User findByUseridAndPassword(String userid, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			// TODO Auto-generated method stub
			//定义SQL
			String sql = "select * from user where userid = ? and password = ?";
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userid,password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
	

}
