package com.zking.Entity;

public class Student {

	private Integer sid;//���
	
	private Integer age;//����
	
	private String sex;//�Ա�
	
	private String sname;//����

	

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
