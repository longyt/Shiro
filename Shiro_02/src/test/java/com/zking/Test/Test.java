package com.zking.Test;

import java.security.Security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test {
	
	public static void main(String[] args) {
		//��ȡshiro.ini�����ļ�  ����SecurityManage����
				Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro_Realm.ini");
				//ͨ�������õ�SecurityManage
				SecurityManager securityManager = factory.getInstance();
				//��securitymanage���������뵽shiro��֤������
				SecurityUtils.setSecurityManager(securityManager);
				
				//��ȡSubject����
				Subject subject = SecurityUtils.getSubject();
				//Token ����
				AuthenticationToken Token=new UsernamePasswordToken("longyt","123");
				try {
					subject.login(Token);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//��֤�Ƿ�ͨ����֤
				Boolean f = subject.isAuthenticated();
				System.out.println(" ��֤�Ƿ�ͨ�� �� "+f);
				
				boolean admin = subject.hasRole("admin");
				boolean teacher = subject.hasRole("teacher");
				boolean user = subject.hasRole("user");
				
				System.out.println(" "+admin+"  "+teacher+"  "+user);
				
				boolean add = subject.isPermitted("add");
				boolean delete = subject.isPermitted("delete");
				boolean update = subject.isPermitted("update");
				boolean query = subject.isPermitted("query");
				
				System.out.println(add+"  "+delete+"  "+update+"  "+query);
				
	}

}
