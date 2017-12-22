package com.zking.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zking.Entity.PermissionEntity;
import com.zking.Entity.RolesEntity;
import com.zking.Entity.UserEntity;

public class UserdaoImpl {
	
	private  SessionFactory sessionFactory;//sessionFactory
	public List<String> RoleList=new ArrayList<String>();//角色集合
	public List<String> PermissionList=new ArrayList<String>();//权限集合
	//打开Session
	public Session OpenSesion() {
		Configuration configuration=new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
	//关闭Session
	public void Myclose(Session session) {
		session.close();
		sessionFactory.close();
	}
	//查询学生对象
	public UserEntity query(String UserName) {
		return (UserEntity) OpenSesion().createQuery("from user u where u.UserName=:name").setParameter("name",UserName ).getSingleResult();
	}
	//查询对应的权限以及角色
	public void QueryRoleAndPermission(String UserName) {
		//并打开Session
		Session session = this.OpenSesion();
		UserEntity user = (UserEntity) session.createQuery("from user u where u.UserName=:name").setParameter("name", UserName).getSingleResult();
		List<RolesEntity> rolelist = user.getList();
		for (RolesEntity rolesEntity : rolelist) {
			RoleList.add(rolesEntity.getRoleName());
			for (PermissionEntity permission : rolesEntity.getPermissionList()) {
				if(!PermissionList.contains(permission.getPname())) {					
					PermissionList.add(permission.getPname());
				}
			}
		}
		//关闭session
		this.Myclose(session);
	}
	
	

}
