package com.zcx.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * 数据库的工具类
 * @author zcx
 */
public class DBUtil {
	private static String className = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	static {
		Properties properties = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("/jdbc.properties");
		
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		className = properties.getProperty("className");	
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			//加载驱动
			Class.forName(className);
			
			//创建连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;	
	}
	
	/**
	 * 关闭资源
	 * @param rs
	 * @param statement
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement statement, Connection conn) {
		//关闭连接
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行DML操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = getConnection();
		PreparedStatement pStatement = null;
		int n = 0;
		
		try {
			pStatement = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; ++i) {
				pStatement.setObject(i + 1, params[i]);
			}
			
			n = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pStatement, conn);
		}
		
		return n;
	}
	
	/**
	 * 提取查询操作
	 * @param sql 需要执行的SQL语句
	 * @param clazz 类信息
	 * @param params SQL语句中的参数
	 * @return
	 */
	public static <T> List<T> executeQuery(String sql, Class clazz, Object... params){
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		
		if(params.length > 1) {
			if("bug".equals(params[0])) {
				params = (Object[]) params[1];
			}
		}
		
		try {
			//建立连接
			conn = getConnection();
			//创建SQL发送器
			pStatement = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; ++i) {
				pStatement.setObject(i + 1, params[i]);
			}
			
			//发送SQL命令
			rs = pStatement.executeQuery();
			
			//获取结果集结构
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取表的列数
			int count = rsmd.getColumnCount();
			
			//处理结果
			while(rs.next()) {
				//根据传进来的类信息创建对象
				T t = (T)clazz.newInstance();
				
				for(int i = 0; i < count; ++i) {
					//获取每列的列名
					String columnName = rsmd.getColumnLabel(i + 1);
					
					//得到每列对应的值
					Object value = rs.getObject(columnName);
					
					/*
					 * 将值通过set方法赋值给对象
					 */
					String methodName = "set" + columnName.substring(0, 1).toUpperCase()
							+ columnName.substring(1);
//					String methodName = "set" + columnName.substring(0, 1).toUpperCase()
//							+ columnName.substring(1).toLowerCase();
					//得到每列数据的类型名
					String columnClassName = rsmd.getColumnClassName(i + 1);
					//通过反射获取参数的类信息
					Class parameterTypes = Class.forName(columnClassName);
					//通过反射获得相应的set方法，并执行
					Method method = clazz.getMethod(methodName, parameterTypes);
					method.invoke(t, value);
				}
				
				list.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pStatement, conn);
		}
		
		return list;
	}
	
	public static int getCount() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int cnt=0;
		try {
			pstm = conn.prepareStatement("select count(*) from employees");
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pstm, conn);
		}
		return cnt;
	}
}

















