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

@Entity(name="role")
public class RolesEntity {
	
	@Id
	@GenericGenerator(strategy="increment",name="id")
	@GeneratedValue(generator="id")
	private Integer RoleId;//角色编号
	
	private String RoleName;//角色名字
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="User_Roles",
	joinColumns= {@JoinColumn(name="RoleId")},
	inverseJoinColumns= {@JoinColumn(name="UserId")}
	)
	List<UserEntity> Userlist;//多个用户
	
	@ManyToMany(mappedBy="Rolelist")
	List<PermissionEntity> PermissionList;
	
	
	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public List<UserEntity> getUserlist() {
		return Userlist;
	}

	public void setUserlist(List<UserEntity> userlist) {
		Userlist = userlist;
	}

	public List<PermissionEntity> getPermissionList() {
		return PermissionList;
	}

	public void setPermissionList(List<PermissionEntity> permissionList) {
		PermissionList = permissionList;
	}
	
	

}
