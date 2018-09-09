package com.suwen;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.util.StringUtils;

public class CroseFifter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletRequest  request=(HttpServletRequest) arg0;
		String Origin = request.getHeader("Origin");
		if(!StringUtils.isEmpty(Origin)) {
	response.addHeader("Access-Control-Allow-Origin", Origin);
		}
		String header = request.getHeader("Access-Control-Request-Headers");
		if(!StringUtils.isEmpty(header)) {
			response.addHeader("Access-Control-Allow-Headers",header);
		}
		response.addHeader("Access-Control-Allow-Methods", "*");
		
		response.addHeader("Access-Control-MAX-Age", "3600");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
