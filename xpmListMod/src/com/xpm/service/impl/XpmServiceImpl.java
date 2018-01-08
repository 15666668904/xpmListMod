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
 * @author ��������  E-mail: email��ַ 
 * @version ����ʱ�䣺2018��1��5�� ����9:40:06 
 * ��˵�� 
 */
/**
 * @author 19516
 *
 */
public class XpmServiceImpl implements XpmService{



	@Override
	public  String getallChild()  {
		Connection connection=getconn();
		System.out.println("������modsid");
		Scanner scanner=new Scanner(System.in);
		String modSid=scanner.next();
		System.out.println("���ڲ�ѯ�����Ժ�...");
		try {
			System.out.println("��mod_sid�����нڵ�Ϊ---->"+getchild(modSid, connection));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlserverUtil.connCloser(connection);
		return null;
	}
	/**
	 * ȡ�����ݿ����ӷ���
	 * @return
	 */
	private Connection getconn(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������ݿ�ip���˿�:");
		String ip=scanner.nextLine();
		System.out.println("���������ݿ�����:");
		String dataBaseName=scanner.nextLine();
		System.out.println("���������ݿ��û���:");
		String userName=scanner.nextLine();
		System.out.println("���������ݿ�����:");
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
