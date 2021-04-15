package com.hongjianjie.notes.dao;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 创建对数据库连接对象，方便与数据库进行对接
 * @author JJ
 *
 */

public class BaseDao {
	public Connection con = new com.hongjianjie.notes.util.DbUtil().getCon();
	/**
	 * 关闭链接，释放资源
	 */
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
