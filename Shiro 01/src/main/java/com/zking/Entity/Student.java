package com.zking.Entity;

public class Student {

	private Integer sid;//编号
	
	private Integer age;//年龄
	
	private String sex;//性别
	
	private String sname;//姓名

	

	public Student(Integer age, String sex, String sname) {
		super();
		this.age = age;
		this.sex = sex;
		this.sname = sname;
	}



	public Student() {
		super();
	}



	public Integer getSid() {
		return sid;
	}



	public void setSid(Integer sid) {
		this.sid = sid;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
	
	
	
}
