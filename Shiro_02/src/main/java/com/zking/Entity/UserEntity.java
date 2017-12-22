package com.zking.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.CascadeStyle;

@Entity(name="user")
public class UserEntity {
	
	@Id
	@GenericGenerator(strategy="increment",name="id")
	@GeneratedValue(generator="id")
	private Integer UserId;//�û����
	
	private String UserName;//�û���
	
	private String UserPassWord;//�û�����
	
	@ManyToMany(mappedBy="Userlist")
	List<RolesEntity> list;

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassWord() {
		return UserPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		UserPassWord = userPassWord;
	}

	public List<RolesEntity> getList() {
		return list;
	}

	public void setList(List<RolesEntity> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserEntity [UserId=" + UserId + ", UserName=" + UserName + ", UserPassWord=" + UserPassWord + ", list="
				+ list + "]";
	}
	
	

	
	

}
