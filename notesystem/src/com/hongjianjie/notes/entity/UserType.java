package com.hongjianjie.notes.entity;

/**
 * 登录类型实体，枚举类
 * @author JJ
 *
 */

public enum UserType {
	USERLOGIN("用户登录",0),USERREGIST("用户注册",1),ADMIN("管理员",2);
	private String name;
	private int index;
	private UserType(String name,int index){
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString(){
		return this.name;
	}
	//重载tostring方法
}
