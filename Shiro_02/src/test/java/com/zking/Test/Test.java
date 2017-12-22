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
		//读取shiro.ini配置文件  加载SecurityManage工厂
				Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro_Realm.ini");
				//通过工厂拿到SecurityManage
				SecurityManager securityManager = factory.getInstance();
				//把securitymanage管理器加入到shiro认证环境中
				SecurityUtils.setSecurityManager(securityManager);
				
				//获取Subject对象
				Subject subject = SecurityUtils.getSubject();
				//Token 令牌
				AuthenticationToken Token=new UsernamePasswordToken("longyt","123");
				try {
					subject.login(Token);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//验证是否通过验证
				Boolean f = subject.isAuthenticated();
				System.out.println(" 验证是否通过 ： "+f);
				
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
