package com.suwen;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class jsonpAdvice extends AbstractJsonpResponseBodyAdvice {

	public jsonpAdvice() {
       super("callback2");
	}

}
