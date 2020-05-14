package com.hwy.www.po;
/**
 * 用户角色关联表字段实体类
 */
public class Ui {

	private String uid;
	private String code;
	
	
	public Ui(String uid, String code) {
		super();
		this.uid = uid;
		this.code = code;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
}
