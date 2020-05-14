package com.hwy.www.po;

import java.util.Date;
/**
 * 导师安排表字段实体类
 */
public class Tplan {
	
	private String tid;
	private Date time;
	private String plan;
	
	
	public Tplan(String tid, Date time, String plan) {
		super();
		this.tid = tid;
		this.time = time;
		this.plan = plan;
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
}
