package com.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

	@Autowired
	private GirlInterface girlInterface;

	@RequestMapping(value = "/get/{id}")
	public Girl query(@PathVariable("id") Integer id) {
		return girlInterface.findOne(id);
	}

}
