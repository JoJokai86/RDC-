package com.hongjianjie.notes.entity;

/**
 * 用户实体
 * @author JJ
 *
 */

public class User {
	private int id;
	private String accout;
	private String password;
	private String petname;
	private int notenumber;
	private boolean isopen;
	private String notetitle;
	private String note;
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNotetitle() {
		return notetitle;
	}
	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public int getNotenumber() {
		return notenumber;
	}
	public void setNotenumber(int notenumber) {
		this.notenumber = notenumber;
	}
	public boolean isIsopen() {
		return isopen;
	}
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}
	
	

}
