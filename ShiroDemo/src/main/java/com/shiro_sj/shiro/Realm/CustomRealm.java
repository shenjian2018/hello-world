/**
 * 
 */
/**
 * @author CPR199
 *
 */
package com.shiro_sj.shiro.Realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.shiro_sj.shiro.Dao.Userdao;
import com.shiro_sj.shiro.pojo.User;

public class CustomRealm extends AuthorizingRealm {
	@Resource
	private Userdao userdao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String username = (String) arg0.getPrimaryPrincipal();
		// 获取用户数据
		Set<String> roles = getRolesByUserName(username);
		Set<String> permissions = getPermissionsByUserName(username);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(roles);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// 1.获取用户名字
		String userName = (String) arg0.getPrincipal();
		String password = getPasswordByUserName(userName);
		if (password == null) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password,
				"customRealm");
		simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
		return null;
	}

	@SuppressWarnings("unused")
	private Set<String> getPermissionsByUserName(String userName) {
		Set<String> set = new HashSet<String>();
		set.add("user:add");
		set.add("user:delete");
		return set;

	}

	public Set<String> getRolesByUserName(String username) {
		System.out.println("从数据库中 或者 缓存中获取用户授权数据");
		List<String> queryRolesByUserName = userdao.queryRolesByUserName(username);
		Set<String> set = new HashSet<String>(queryRolesByUserName);
		return set;

	}

	public String getPasswordByUserName(String username) {
		User passwordByUserName = userdao.getPasswordByUserName(username);
		if (passwordByUserName != null) {
			return passwordByUserName.getPassword();
		}
		return null;

	}

}