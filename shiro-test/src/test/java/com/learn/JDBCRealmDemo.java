package com.learn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;

public class JDBCRealmDemo {
	@Test
	public void testAuthentication() {
		JdbcRealm jdbcRealm = new JdbcRealm();
		DataSource  dataSource=new DataSource();
		jdbcRealm.setDataSource(dataSource);
		jdbcRealm.setPermissionsLookupEnabled(true);
		// 1.構建securityManager環境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(jdbcRealm);

		// 2.主題提交認證請求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();

		// 3. 驗證token
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("shenjian", "123");
		subject.login(usernamePasswordToken);
		subject.checkRole("admin");
		subject.checkPermissions("user:delete");
		System.out.println("isAuthenticated:" + subject.isAuthenticated());

	}
}
