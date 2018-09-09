package com.learn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class CustRealmTest {
	@Test
	public void testAuthentication() {
		CustRealm custRealm = new CustRealm();
		// 1.����securityManager�h��
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(custRealm);
		// �O�ü����㷨
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(1);
		// ���Զ��xrealm���O��hashmacher
		custRealm.setCredentialsMatcher(hashedCredentialsMatcher);

		// 2.���}�ύ�J�CՈ��
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();

		// 3. ��Ctoken
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("shenjian", "123");
		subject.login(usernamePasswordToken);
		subject.checkRole("admin");
		subject.checkPermissions("user:delete");
		System.out.println("isAuthenticated:" + subject.isAuthenticated());

	}
}
