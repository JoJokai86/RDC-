package com.hongjianjie.notes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 与数据库建立链接
 * @author JJ
 *
 */


public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/db_note?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	private String dbUserName="root"; // 用户名
	private String dbPassword="123456"; // 密码
	private String jdbcName="com.mysql.cj.jdbc.Driver"; // 驱动名称

	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);//驱动加载
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);//获取链接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	/**
	 * 测试数据库是否连接成功
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
