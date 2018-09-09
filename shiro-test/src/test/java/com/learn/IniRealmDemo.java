package com.learn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class IniRealmDemo {

	@Test
	public void testAuthentication() {
		IniRealm iniRealm = new IniRealm("classpath:user.ini");

		// 1.����securityManager�h��
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(iniRealm);

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
