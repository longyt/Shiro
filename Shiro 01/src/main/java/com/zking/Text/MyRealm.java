package com.zking.Text;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zking.dao.StudentShiro;

public class MyRealm extends AuthorizingRealm{

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection Token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token2=(UsernamePasswordToken) Token;
		String username = token2.getUsername();
		String password = token2.getPassword().toString();
		System.out.println("用户闯入的值："+username+"   "+password);
		String datapass = new StudentShiro().getStudentPass(username).getAge().toString();
		//String DataPass="123";//加入拿到密码是123
		
		//通过传入的用户名到数据库查询密码  然后就info信息返回
		AuthenticationInfo info = new SimpleAuthenticationInfo(username, datapass, "");
		return info;
	}

}
