package com.hwy.www.po;
/**
 * 用户表字段实体类
 */
public class User {
	
	private String userid;
	private String password;
	private String username;
	private String number;
	private String institude;
	
	
	public User(String userid, String password, String username, String number, String institude) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.number = number;
		this.institude = institude;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getInstitude() {
		return institude;
	}


	public void setInstitude(String institude) {
		this.institude = institude;
	}
	
	
}
