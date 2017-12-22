package com.zking.Text;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Text {
	
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
		AuthenticationToken Token=new UsernamePasswordToken("jk","11");
		try {
			subject.login(Token);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//��֤�Ƿ�ͨ����֤
		Boolean f = subject.isAuthenticated();
		System.out.println(" �Ƿ�ͨ�� �� "+f);
	}

}
