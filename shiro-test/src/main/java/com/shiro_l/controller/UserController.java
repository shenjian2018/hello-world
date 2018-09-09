package com.shiro_l.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiro_l.entity.User;

@Controller
public class UserController {
	@RequestMapping("subLogin")
	@ResponseBody
	public String logininfo(User user) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			subject.login(usernamePasswordToken);
		} catch (Exception e) {
			return e.getMessage();
		}

		return "成功";
	}

}
