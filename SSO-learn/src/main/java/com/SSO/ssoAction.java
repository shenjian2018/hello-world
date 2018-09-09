package com.SSO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ssoAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String gotoURL;

	public String ssologin() {
		Boolean isok = SSOUtils.isok(username, password);
		if (isok) {
			Cookie cookie = new Cookie("SSOCheck", "SSO");
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		}

		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGotoURL() {
		return gotoURL;
	}

	public void setGotoURL(String gotoURL) {
		this.gotoURL = gotoURL;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
