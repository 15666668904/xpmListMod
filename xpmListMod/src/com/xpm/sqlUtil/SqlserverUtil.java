/**
 * 
 */ 
package com.xpm.sqlUtil; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * @author 作者姓名  E-mail: email地址 
 * @version 创建时间：2018年1月5日 上午9:24:29 
 * 类说明 
 */
/**
 * @author 19516
 *
 */
public class SqlserverUtil {
	public static Connection getconn(String ip,String dataBaseName,String user_name,String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库驱动注册失败");
			return null;
		}
		Connection connection=null;
		String url="jdbc:sqlserver://"+ip+";databaseName="+dataBaseName;
		System.out.println("拼接数据库url为-------->"+url);
		try {
			connection=DriverManager.getConnection(url,user_name,password);
			System.out.println("数据库成功连接");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接打开失败");
			return null;
		}
		return connection;
	}

	public static void connCloser(Connection connection)
	{
		if(connection==null){
			return;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
