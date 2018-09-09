package com.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.SSO.SSOUtils;
import com.opensymphony.xwork2.ActionSupport;

public class demo1 extends ActionSupport {
	private String gotoURL;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (SSOUtils.checkCookie(request)) {
			return SUCCESS;
		}
		gotoURL = "/SSO-learn/demo1/main.action";
		
		return LOGIN;
	}

	public String getGotoURL() {
		return gotoURL;
	}

	public void setGotoURL(String gotoURL) {
		this.gotoURL = gotoURL;
	}

}
