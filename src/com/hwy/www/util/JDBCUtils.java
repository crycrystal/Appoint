package com.hwy.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * JDBC工具类
 */
public class JDBCUtils {
	
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/appoint?uesSSL=false&serverTimezone=UTC","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 得到数据源的通用方法
	 */
	//声明静态数据源成员变量
	private static DataSource ds;
	public static DataSource getDataSource() {
		return ds;
	}
	
	
	/**
	 * 增删改的通用方法
	 * @param String sql 要执行的SQL语句
	 * @param Object[] obj 对象类型的数组，存放着SQL执行的占位符参数
	 * @return
	 */
	 public static boolean update(String sql,Object... args){
	        Connection conn = null;
	        PreparedStatement ps = null;
	        try {
	            conn = getConnection();
	            ps = conn.prepareStatement(sql);

	            for (int i=0;i<args.length;i++){
	                ps.setObject(i+1,args[i]);
	            }
	            int i = ps.executeUpdate();

	            if (i>0) {
	            	return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            //关闭
	            close(conn,ps,null);
	        }
	        return false;
	    }
	 
	 
	 /**
	  * 查询的通用方法
	  * @param sql
	  * @param args
	  * @return
	  */
	 public static List<Map<String,Object>> executeQuery(String sql,Object... args){
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet set = null;
	        try {
	            conn = JDBCUtils.getConnection();
	            ps = conn.prepareStatement(sql);
	            //有可能有参数
	            for (int i=0;i<args.length;i++){
	                ps.setObject(i+1,args[i]);
	            }
	            //执行
	            set = ps.executeQuery();
	            //需要将所有数据都存放到 List中，每一行用一个 map存放
	            List<Map<String,Object>> list = new ArrayList<>();
	            //获取本次查询结果集有多少列
	            int count = set.getMetaData().getColumnCount();

	            while(set.next()){
	            	//一行数据用一个map接收
	                Map<String, Object> map = new HashMap<>();
	                /**
	                 * 通过  getMetData().getColumnLabel() 获取列
	                 * 因为用的map键值对集合
	                 * 得到了列就能得到相应的values值
	                 */
	                for(int i=0;i<count;i++){
	                    String name = set.getMetaData().getColumnLabel(i+1);
	                    map.put(name,set.getObject(name));
	                }
	                //将每行的map存放到 List中
	                list.add(map);
	            }
	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            close(conn,ps,set);
	        }
	        return null;
	   	}
	 
	 
	 /**
	  * 关闭的通用方法（先进后出）
	  * 每个关闭的方法try-catch一次
	  */
	 private static void close(Connection conn,Statement stmt,ResultSet rs){
		 
			 if(rs!=null){
				 try {
					rs.close();
				} catch (SQLException e) {}
			 }
			 
			 if(stmt!=null){
				 try {
					stmt.close();
				} catch (SQLException e) {}
			 }
			 
			 if(conn != null){
				 try {
					conn.close();
				} catch (SQLException e) {}
			 }
	
	 }
	 
	 //重载关闭方法
	 public static void close(Connection conn,Statement stmt) {
		 close(conn, stmt, null);
	 }
	 
	 
}
