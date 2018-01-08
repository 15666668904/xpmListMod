/**
 * 
 */ 
package com.xpm.controller; 

import com.xpm.service.XpmService;
import com.xpm.service.impl.XpmServiceImpl;

/** 
 * @author 作者姓名 单振龙  E-mail: zhenlong.shan@qq.com 
 * @version 创建时间：2018年1月5日 上午10:00:12 
 * 类说明 遍历节点下所有子节点主类
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
		System.out.println("查找耗时---->"+(System.currentTimeMillis()-startTime)+"MS");
	}
}
