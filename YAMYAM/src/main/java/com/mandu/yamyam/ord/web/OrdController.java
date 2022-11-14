package com.mandu.yamyam.ord.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdController {

	@RequestMapping("/odAd") 
	public String odAd(Model model) {
		return "order/odAd";
	}
	
	@RequestMapping("/prdOutAd") 
	public String prdOutAd(Model model) {
		return "order/prdOutAd";
	}
	
	@RequestMapping("/prdOutList") 
	public String prdOutList(Model model) {
		return "order/prdOutList";
	}
	
	@RequestMapping("/prdReAd") 
	public String prdReAd(Model model) {
		return "order/prdReAd";
	}
}
