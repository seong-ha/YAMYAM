package com.mandu.yamyam.eqp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandu.yamyam.eqp.service.EqpService;

@Controller
public class EqpController {
	@Autowired
	EqpService eqpService;
	
	@RequestMapping("/eqpAd")
	public String eqpAd(Model model) {
		model.addAttribute("eqpActList", eqpService.getEqpActList());
		// 가동비가동 가져오기
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
