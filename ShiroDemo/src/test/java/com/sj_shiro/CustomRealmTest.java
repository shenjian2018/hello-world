package com.sj_shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.shiro_sj.shiro.Realm.CustomRealm;

public class CustomRealmTest {
	@Test
	public void testAuthentication() {
		 CustomRealm customRealm = new CustomRealm();

		// 1.构建secutityManager环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(customRealm);
		
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(1);
		customRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		
		
		//2.主体提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		
		 UsernamePasswordToken token = new  UsernamePasswordToken("sj", "123");
		 subject.login(token);
		 
		 System.out.println("isAuthenticated"+subject.isAuthenticated());
		 
		 subject.checkRole("admin");
		 subject.checkPermissions("user:add","user:delete");
             
		 
	}

}
