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
import com.hwy.www.po.User;
import com.hwy.www.service.UserService;
import com.hwy.www.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名和密码数据
		Map<String, String[]> map = request.getParameterMap();
		
		//封装User对象
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String number = request.getParameter("number");
		String institute = request.getParameter("institute");
		User user = new User(userid, password, username, number, institute);
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用Service查询
		UserService service = new UserServiceImpl();
		User u = service.login(user);
		
		ResultInfo info = new ResultInfo();
		
		//判断用户对象是否为null
		if(u == null) {
			//登录失败（用户名密码错误）
			info.setFlag(false);
			info.setErrorMsg("用户名或密码错误");
		}else {
			//登录成功
			info.setFlag(true);
		}
		
		//响应数据(json)
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(), info);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
