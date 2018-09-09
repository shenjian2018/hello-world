package com.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

//自定義realm
public class CustRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		
		Set<String> roles = getRolesByUserName(username);
        Set<String> permissions = getPermissionsByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.從主題傳過來的用戶信息用獲取用戶名信息
		String username = (String) token.getPrincipal();

        //2.通过用户名到数据库中获得凭证
        String password = getPasswordByUserName(username);
		if (password == null) {
			return null;
		}
		SimpleAuthenticationInfo satif = new SimpleAuthenticationInfo("shenjian", password, "CustRealm");
		satif.setCredentialsSalt(ByteSource.Util.bytes("sh"));
		return satif;
	}
	
	public static void main(String[] args) {
	   Md5Hash md5Hash = new 	Md5Hash("123456","sh");
	   System.out.println(md5Hash.toString());
	}
	
	 private Set<String> getPermissionsByUserName(String userName) {
	        Set<String> sets = new HashSet<String>();
	        sets.add("user:add");
	        sets.add("user:delete");
	        return sets;
	    }

	    private Set<String> getRolesByUserName(String userName) {
	        Set<String> sets = new HashSet<String>();
	        sets.add("admin");
	        sets.add("user");
	        return sets;
	    }
	    
	    private String getPasswordByUserName(String userName) {
	        return userMap.get(userName);
	    }
	    Map<String,String> userMap = new HashMap<String, String>(16);

	    {
	        userMap.put("shenjian","547b957f2b45a4bac999101f61a57e75");
	        super.setName("CustRealm");
	    }

}
