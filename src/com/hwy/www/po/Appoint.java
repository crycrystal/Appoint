package com.hwy.www.po;

import java.util.Date;
/**
 * 预约单表字段实体类
 */
public class Appoint {
	
	private String id;
	private String sid;
	private String tid;
	private Date submitTime;
	private Date appointTime;
	private int status;
	
	
	public Appoint(String id, String sid, String tid, Date submitTime, Date appointTime, int status) {
		super();
		this.id = id;
		this.sid = sid;
		this.tid = tid;
		this.submitTime = submitTime;
		this.appointTime = appointTime;
		this.status = status;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public Date getSubmitTime() {
		return submitTime;
	}


	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}


	public Date getAppointTime() {
		return appointTime;
	}


	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
