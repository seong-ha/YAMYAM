package com.mandu.yamyam.eqp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EqpController {
	
	@RequestMapping("/eqpAd")
	public String eqp() {
		return "eqp/eqpAd";
	}
}
