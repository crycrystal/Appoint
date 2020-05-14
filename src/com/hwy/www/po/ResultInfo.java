package com.hwy.www.po;

import java.io.Serializable;
import java.util.Objects;

/**
 *用于封装后端返回前端数据对象
 */
public class ResultInfo implements Serializable {
	private boolean flag;	//后端返回结果正常位true，发生异常返回false
	private Objects data;	//后端返回结果数据对象
	private String errorMsg;	//发生异常的错误信息
	
	//无参构造方法
	public ResultInfo() {
		super();
	}
	
	public ResultInfo(boolean flag) {
		super();
		this.flag = flag;
	}

	/**
	 * 有参构造
	 * @param flag
	 * @param errorMsg
	 */
	public ResultInfo(boolean flag, String errorMsg) {
		super();
		this.flag = flag;
		this.errorMsg = errorMsg;
	}

	/**
	 * 有参构造方法
	 * @param flag
	 * @param data
	 * @param errorMsg
	 */
	public ResultInfo(boolean flag, Objects data, String errorMsg) {
		super();
		this.flag = flag;
		this.errorMsg = errorMsg;
	}

	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Objects data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
