package com.zking.Test;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.Session;

import com.zking.Entity.PermissionEntity;
import com.zking.Entity.RolesEntity;
import com.zking.Entity.UserEntity;
import com.zking.dao.UserdaoImpl;

import antlr.Token;

public class Realm extends AuthorizingRealm{
	
	

	//��Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub��
		//�õ��û���
		String UserName = (String) arg0.getPrimaryPrincipal();
		//�������
		UserdaoImpl userdaoImpl  = new UserdaoImpl();
		userdaoImpl.QueryRoleAndPermission(UserName);
		//��ӷ���
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRoles(userdaoImpl.RoleList);
		info.addStringPermissions(userdaoImpl.PermissionList);
		return info;	
	}
	
	//��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		//�õ��û���
		UsernamePasswordToken Token2=(UsernamePasswordToken) arg0;
		String username = Token2.getUsername();
		//��õ�ǰ�û�����
		UserdaoImpl userdaoImpl=new UserdaoImpl();
		UserEntity userEntity = userdaoImpl.query(username);
		//���ݶ����õ�����
		AuthenticationInfo info=new SimpleAuthenticationInfo(username, "123",this.getName());
		//������Ϣ
		return info;
	}

	
	
}
