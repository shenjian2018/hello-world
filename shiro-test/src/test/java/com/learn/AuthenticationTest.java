package com.learn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

	@Before
	public void addUser() {
		simpleAccountRealm.addAccount("shenjian", "123");
	}

	@Test
	public void testAuthentication() {

		// 1.構建securityManager環境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);

		// 2.主題提交認證請求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();

		// 3. 驗證token
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("shenjian", "123");
		subject.login(usernamePasswordToken);
		
		System.out.println("isAuthenticated:"+subject.isAuthenticated());

	}

}
