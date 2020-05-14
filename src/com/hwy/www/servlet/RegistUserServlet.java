package com.hwy.www.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwy.www.po.ResultInfo;
import com.hwy.www.po.Ui;
import com.hwy.www.po.User;
import com.hwy.www.service.UserService;
import com.hwy.www.service.UserServiceImpl;

/**
 * Servlet implementation class RegistUserServlet
 */
@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取数据
		Map<String, String[]> map1 = request.getParameterMap();
		Map<String, String[]> map2 = request.getParameterMap();
		
		//创建用户实体，封装对象
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String number = request.getParameter("number");
		String institute = request.getParameter("institute");
		User user = new User(userid, password, username, number, institute);
		try {
			BeanUtils.populate(user, map1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String uid = request.getParameter("uid");
		String code = request.getParameter("code");
		Ui ui = new Ui(uid, code);
		try {
			BeanUtils.populate(ui, map2);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//调用service完成注册
		UserService service = new UserServiceImpl();
		boolean flag = service.regist(user, ui);
		ResultInfo info = new ResultInfo();
		
		//响应结果
		if(flag) {
			//注册成功
			info.setFlag(true);
		}else {
			//注册失败
			info.setFlag(false);
			info.setErrorMsg("注册失败！");
		}
		
		//将info对象序列化为json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);
		
		//将json数据写回客户端，设置content-type
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
