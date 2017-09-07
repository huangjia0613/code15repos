package com.bwf.springmvcday01.pojo;

import java.util.Date;

public class User {

private int id;
	
	private String name;
	
	private Date birthday;
	
	private String sex;

	public User() {
		super();
	}

	public User(String name, Date birthday, String sex) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}

	public User(int id, String name, Date birthday, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", sex=" + sex + "]";
	}
}
