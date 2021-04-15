package com.hongjianjie.notes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hongjianjie.notes.entity.User;
/**
 * 用户dao类，继承basedao类
 * @author JJ
 *
 */

public class UserDao extends BaseDao {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user) throws Exception {
		String sql = "insert into db_user values(null,?,?,null,null,null,null,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getAccout());
        pstmt.setString(2, user.getPassword());
        return pstmt.executeUpdate();
	}
	
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User userLogin(User user) throws Exception {
		String sql = "select * from db_user where accout=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getAccout());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();//返回结果集
        User resultUser=null;
        if(rs.next()) {
        	resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setAccout(rs.getString("accout"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setIsopen(rs.getBoolean("isopen"));
            resultUser.setNotenumber(rs.getInt("notenumber"));
            resultUser.setPetname(rs.getString("petname"));
            resultUser.setNote(rs.getString("note"));
            resultUser.setNotetitle(rs.getString("notetitle"));
        }
        return resultUser;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(User user)throws Exception {
		String sql="update db_user set password=?,petname=?,note=?,isopen=?,notetitle=?,notenumber=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getPassword());
		pstmt.setString(2,user.getPetname());
		pstmt.setString(3,user.getNote());
		pstmt.setBoolean(4, user.isIsopen());
		pstmt.setString(5, user.getNotetitle());
		pstmt.setInt(6,user.getNotenumber());
		pstmt.setInt(7,user.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户列表，用于对用户公开笔记的陈列
	 * @return
	 * @throws Exception
	 */
	public ResultSet userList() throws Exception {
		String sql = "select * from db_user where isopen=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setBoolean(1, true);
		ResultSet rs=pstmt.executeQuery();
		return rs;
	}

	/**
	 * 管理员的用户列表
	 * @return
	 * @throws Exception
	 */
	public ResultSet userList1() throws Exception {
		String sql = "select * from db_user ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		return rs;
	}


	
	/**
	 * 通过账号来查找用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User userLoginWithAccout(User user) throws Exception {
		String sql = "select * from db_user where accout=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getAccout());
        ResultSet rs=pstmt.executeQuery();//返回结果集
        User resultUser=null;
        if(rs.next()) {
        	resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setAccout(rs.getString("accout"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setIsopen(rs.getBoolean("isopen"));
            resultUser.setNotenumber(rs.getInt("notenumber"));
            resultUser.setPetname(rs.getString("petname"));
            resultUser.setNote(rs.getString("note"));
            resultUser.setNotetitle(rs.getString("notetitle"));
        }
        return resultUser;
	}
	
	/**
	 * 通过昵称来查找笔记公开的用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User userLoginWithPetname(User user) throws Exception {
		String sql = "select * from db_user where petname=? and isopen=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getPetname());
		pstmt.setBoolean(2, user.isIsopen());
        ResultSet rs=pstmt.executeQuery();//返回结果集
        User resultUser=null;
        if(rs.next()) {
        	resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setAccout(rs.getString("accout"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setIsopen(rs.getBoolean("isopen"));
            resultUser.setNotenumber(rs.getInt("notenumber"));
            resultUser.setPetname(rs.getString("petname"));
            resultUser.setNote(rs.getString("note"));
            resultUser.setNotetitle(rs.getString("notetitle"));
        }
        return resultUser;
	}
	
	/**
	 * 通过笔记标题来查找笔记公开的用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User searchWithNotetitle(User user)throws Exception {
		String sql = "select * from db_user where notetitle=? and isopen=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getNotetitle());
		pstmt.setBoolean(2, user.isIsopen());
        ResultSet rs=pstmt.executeQuery();//返回结果集
        User resultUser=null;
        if(rs.next()) {
        	resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setAccout(rs.getString("accout"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setIsopen(rs.getBoolean("isopen"));
            resultUser.setNotenumber(rs.getInt("notenumber"));
            resultUser.setPetname(rs.getString("petname"));
            resultUser.setNote(rs.getString("note"));
            resultUser.setNotetitle(rs.getString("notetitle"));
        }
        return resultUser;
	}
	
	/**
	 * 通过笔记的篇数来查找用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User searchWithNoteNumber(User user)throws Exception {
		String sql = "select * from db_user where accout=?and password=? and notenumber=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getAccout());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3,user.getNotenumber());
        ResultSet rs=pstmt.executeQuery();
        User resultUser=null;
        if(rs.next()) {
        	resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setAccout(rs.getString("accout"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setIsopen(rs.getBoolean("isopen"));
            resultUser.setNotenumber(rs.getInt("notenumber"));
            resultUser.setPetname(rs.getString("petname"));
            resultUser.setNote(rs.getString("note"));
            resultUser.setNotetitle(rs.getString("notetitle"));
        }
        return resultUser;
	}
	
	/**
	 * 发布新笔记
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int postNote(User user) throws Exception {
		String sql1 = "select max(notenumber) as num from db_user where accout =?";
		PreparedStatement pst = con.prepareStatement(sql1);
		pst.setString(1, user.getAccout());
		ResultSet r = pst.executeQuery();
		int number =0;
		if(r.next()) {
		number = r.getInt("num");
		number++;
		}
		String sql = "insert into db_user values(null,?,?,?,?,?,null,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getAccout());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getPetname());
        pstmt.setInt(4,number);
        pstmt.setBoolean(5,user.isIsopen());
        pstmt.executeUpdate();
        return number;
	}
	/**
	 * 删除笔记
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int deleteNote(User user)throws Exception{
		String sql = "delete from db_user where accout=? and notenumber=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getAccout());
		pstmt.setInt(2, user.getNotenumber());
		return pstmt.executeUpdate();
	}
	
}
