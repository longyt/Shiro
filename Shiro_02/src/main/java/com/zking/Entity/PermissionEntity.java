package com.zking.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="permission")
public class PermissionEntity {
	
	@Id
	@GenericGenerator(strategy="increment",name="id")
	@GeneratedValue(generator="id")
	private Integer Pid;//权限编号
	
	private String pname;//权限名字
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="Roles_Permission",
	joinColumns= {@JoinColumn(name="Pid")},
	inverseJoinColumns= {@JoinColumn(name="RolesId")})
	List<RolesEntity> Rolelist;
	
	public Integer getPid() {
		return Pid;
	}

	public void setPid(Integer pid) {
		Pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<RolesEntity> getRolelist() {
		return Rolelist;
	}

	public void setRolelist(List<RolesEntity> rolelist) {
		Rolelist = rolelist;
	}
	
	

}
