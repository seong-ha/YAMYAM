package com.mandu.yamyam.eqp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EqpController {
	
	@RequestMapping("/eqpAd")
	public String eqpAd() {
		return "eqp/eqpAd";
	}
	
	@RequestMapping("/uopAd")
	public String uopAd() {
		return "eqp/uopAd";
	}
	
	@RequestMapping("/eqpChkAd")
	public String eqpChkAd() {
		// 설비구분 데이터들 가져와서 model로 내려주기
		return "eqp/eqpChkAd";
	}
}
