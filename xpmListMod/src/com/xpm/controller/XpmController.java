/**
 * 
 */ 
package com.xpm.controller; 

import com.xpm.service.XpmService;
import com.xpm.service.impl.XpmServiceImpl;

/** 
 * @author �������� ������  E-mail: zhenlong.shan@qq.com 
 * @version ����ʱ�䣺2018��1��5�� ����10:00:12 
 * ��˵�� �����ڵ��������ӽڵ�����
 */
/**
 * @author 19516
 *
 */
public class XpmController {
	private static XpmService xpmService=new XpmServiceImpl();
	public static void main(String[] args) {
		Long startTime=System.currentTimeMillis();
		xpmService.getallChild();
		System.out.println("���Һ�ʱ---->"+(System.currentTimeMillis()-startTime)+"MS");
	}
}
