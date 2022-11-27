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
		// 관리탭 입력폼 설비업체리스트 option태그
		model.addAttribute("eqpActList", eqpService.getEqpActList());
		// 관리탭 입력폼 설비가동여부상태코드 option태그
		model.addAttribute("eqpStsList", eqpService.getEqpStsList());
		return "eqp/eqpAd";
	}
	

	@RequestMapping("/uopAd")
	public String uopAd(Model model) {
		model.addAttribute("uopTypeList", eqpService.getUopTypeList());
		return "eqp/uopAd";
	}
	
	@RequestMapping("/eqpChkAd")
	public String eqpChkAd(Model model) {
		// 비가동중인 설비 비가동 정보 가져오기
		model.addAttribute("eqpTypeList", eqpService.getEqpTypeList());
		return "eqp/eqpChkAd";
	}
	
	
}
