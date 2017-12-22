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
		
		//读取shiro.ini配置文件  加载SecurityManage工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro_Realm.ini");
		//通过工厂拿到SecurityManage
		SecurityManager securityManager = factory.getInstance();
		//把securitymanage管理器加入到shiro认证环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		//Token 令牌
		AuthenticationToken Token=new UsernamePasswordToken("jk","11");
		try {
			subject.login(Token);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//验证是否通过验证
		Boolean f = subject.isAuthenticated();
		System.out.println(" 是否通过 ： "+f);
	}

}
