package com.SSO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOUtils {
	private static final String USERNAME = "shenjian";
	private static final String PASSWORD = "456";

	public static Boolean isok(String username, String password) {
		if (username.equals(USERNAME) && password.equals(PASSWORD))
			return true;
		return false;
	}

	public static Boolean checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("SSOCheck") && cookie.getValue().equals("SSO")) {
					return true;
				}
			}
		}

		return false;
	}
}
