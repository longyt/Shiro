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
	public List<String> RoleList=new ArrayList<String>();//��ɫ����
	public List<String> PermissionList=new ArrayList<String>();//Ȩ�޼���
	//��Session
	public Session OpenSesion() {
		Configuration configuration=new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
	//�ر�Session
	public void Myclose(Session session) {
		session.close();
		sessionFactory.close();
	}
	//��ѯѧ������
	public UserEntity query(String UserName) {
		return (UserEntity) OpenSesion().createQuery("from user u where u.UserName=:name").setParameter("name",UserName ).getSingleResult();
	}
	//��ѯ��Ӧ��Ȩ���Լ���ɫ
	public void QueryRoleAndPermission(String UserName) {
		//����Session
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
		//�ر�session
		this.Myclose(session);
	}
	
	

}
