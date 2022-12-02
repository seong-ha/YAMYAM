package com.mandu.yamyam.eqp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.eqp.service.EqpService;

@Controller
public class EqpController {
	@Autowired
	EqpService eqpService;
	@Autowired
	CommService commService;
	
	@RequestMapping("/eqpAd")
	public String eqpAd(Model model) {
		// 관리탭 입력폼 설비업체리스트 option태그
		model.addAttribute("eqpActList", eqpService.getEqpActList());
		// 관리탭 입력폼 설비가동여부상태코드 option태그
		model.addAttribute("eqpStsList", commService.getCommdCdNm("EQP-STS"));
		return "eqp/eqpAd";
	}
	

	@RequestMapping("/uopAd")
	public String uopAd(Model model) {
		// 비가동 구분 종류 가져오기
		model.addAttribute("uopTypeList", commService.getCommdCdNm("UOP-TYPE"));
		return "eqp/uopAd";
	}
	
	@RequestMapping("/eqpChkAd")
	public String eqpChkAd(Model model) {
		// 설비 구분 가져오기
		model.addAttribute("eqpTypeList", commService.getCommdCdNm("EQP-TYPE"));
		// 설비 점검 판정 구분 가져오기
		model.addAttribute("eqpChkRstList", commService.getCommdCdNm("EQP-CHKRST"));
		return "eqp/eqpChkAd";
	}
	
	
}
