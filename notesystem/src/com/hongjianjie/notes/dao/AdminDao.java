package com.hongjianjie.notes.dao;

/**
 * 管理员Dao类，对数据库的访问
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hongjianjie.notes.entity.Admin;

public class AdminDao extends BaseDao {
	/**
	 * 该方法用于管理员登录验证
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public Admin adminLogin(Admin admin) throws Exception {
		String sql = "select * from db_admin where accout=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, admin.getAccout());
        pstmt.setString(2, admin.getPassword());
        ResultSet rs=pstmt.executeQuery();//返回结果集
        Admin resultAdmin=null;
        if(rs.next()) {
        	resultAdmin = new Admin();
        	resultAdmin.setAccout(rs.getString("accout"));
            resultAdmin.setPassword(rs.getString("password"));
        }
        return resultAdmin;
	}
}
