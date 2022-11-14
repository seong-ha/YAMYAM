package com.mandu.yamyam.pro.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProController {

	// 생산계획
	@RequestMapping("/proPlan")
	public String plan(Model model) {
		return "production/proPlan";
	}
	
	// 생산지시관리
	@RequestMapping("/proOrder")
	public String order(Model model) {
		return "production/proOrder";
	}
	
	// 생산지시관리
		@RequestMapping("/planOrdCheck")
	public String orderCheck(Model model) {
		return "production/planOrdCheck";
	}
}
