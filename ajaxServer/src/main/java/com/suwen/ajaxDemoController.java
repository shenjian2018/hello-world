package com.suwen;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ajaxDemoController {

	@RequestMapping("get")
	public Entity get() {
		System.out.println("ajaxDemoContraller.get()");
		return new Entity("get ok");
	}

	/*
	 * @PostMapping("post")
	 * 
	 * @ResponseBody public Entity post(User user) {
	 * System.out.println("ajaxDemoContraller.post()"); return new
	 * Entity("post"+user.getName()); }
	 */
	@RequestMapping("/postJson")

	public Entity postJson(@RequestBody User user) {
		System.out.println("TestController.postJson()");

		return new Entity("postJson " + user.getName());
	}

	@RequestMapping("getCookie")
	public Entity getCookie(@CookieValue(value = "cookie1") String cookie1) {
		System.out.println("TestController.getCookie()");

		return new Entity("getCookie" + cookie1);
	}

	@RequestMapping("getHeader")
	public Entity getHeader(@RequestHeader("x-header1") String header1, @RequestHeader("x-header2") String header2) {
		System.out.println("TestController.getHeader()");

		return new Entity("getHeader" + header1 + "" + header2);
	}
}
