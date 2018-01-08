/**
 * 
 */ 
package com.xpm.sqlUtil; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * @author ��������  E-mail: email��ַ 
 * @version ����ʱ�䣺2018��1��5�� ����9:24:29 
 * ��˵�� 
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
			System.out.println("���ݿ�����ע��ʧ��");
			return null;
		}
		Connection connection=null;
		String url="jdbc:sqlserver://"+ip+";databaseName="+dataBaseName;
		System.out.println("ƴ�����ݿ�urlΪ-------->"+url);
		try {
			connection=DriverManager.getConnection(url,user_name,password);
			System.out.println("���ݿ�ɹ�����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ�ʧ��");
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
