/**
 * 
 */ 
package com.xpm.service.impl; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.xpm.service.XpmService;
import com.xpm.sqlUtil.SqlserverUtil;

/** 
 * @author 作者姓名  E-mail: email地址 
 * @version 创建时间：2018年1月5日 上午9:40:06 
 * 类说明 
 */
/**
 * @author 19516
 *
 */
public class XpmServiceImpl implements XpmService{



	@Override
	public  String getallChild()  {
		Connection connection=getconn();
		System.out.println("请输入modsid");
		Scanner scanner=new Scanner(System.in);
		String modSid=scanner.next();
		System.out.println("正在查询，请稍后...");
		try {
			System.out.println("该mod_sid下所有节点为---->"+getchild(modSid, connection));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlserverUtil.connCloser(connection);
		return null;
	}
	/**
	 * 取得数据库连接方法
	 * @return
	 */
	private Connection getconn(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入数据库ip及端口:");
		String ip=scanner.nextLine();
		System.out.println("请输入数据库名称:");
		String dataBaseName=scanner.nextLine();
		System.out.println("请输入数据库用户名:");
		String userName=scanner.nextLine();
		System.out.println("请输入数据库密码:");
		String password=scanner.nextLine();
		return SqlserverUtil.getconn(ip, dataBaseName, userName, password);
	}


	private static String getchild(String modSid,Connection conn) throws SQLException{
		StringBuffer child=new StringBuffer();
		PreparedStatement preparedStatement=conn.prepareStatement("select * from xPm_DefRecModule where parent_sid=? ");
		preparedStatement.setString(1, modSid);
		ResultSet resultSet= preparedStatement.executeQuery();
		while (resultSet.next()) {
			if(child.toString().equals("")){
				child.append("");
			}
			child.append(resultSet.getString("mod_sid")+",");
		}
		if(child!=null&&!child.toString().equals("")){
			String[]childs=child.toString().split(",");
			for(String m:childs){
				String this_childs=getchild(m, conn);
				if(this_childs!=null&&!this_childs.equals("")){
					child.append(getchild(m, conn));
				}
			}	
		}
		preparedStatement.close();
		return child.toString();
	}

}
