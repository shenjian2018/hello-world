package com.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Boot {

	/*@Autowired
	private GirlPojo girlPojo;*/

	@RequestMapping(value ="/boot")
	public String getDemo(@RequestParam(value="id",required=false,defaultValue="10") Integer ids) {

		return "id: " + ids;
	}
}
