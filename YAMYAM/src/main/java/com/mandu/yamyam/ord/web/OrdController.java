package com.mandu.yamyam.ord.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdController {
	
	// 주문 관리
	@RequestMapping("/odAd") 
	public String odAd(Model model) {
		return "order/odAd";
	}
	
	// 완제품 출고 관리
	@RequestMapping("/prdOutAd") 
	public String prdOutAd(Model model) {
		return "order/prdOutAd";
	}
	
	// 완제품 출고 조회
	@RequestMapping("/prdOutList") 
	public String prdOutList(Model model) {
		return "order/prdOutList";
	}
	
	// 완제품 반품 관리
	@RequestMapping("/prdReAd") 
	public String prdReAd(Model model) {
		return "order/prdReAd";
	}
	
	// 완제품 재고 조회
	@RequestMapping("/prdList")
	public String prdList(Model model) {
		return "order/prdList";
	}
	
	// 완제품 재고 관리
	@RequestMapping("/prdAd")
	public String prdAd(Model model) {
		return "order/prdAd";
	}
	
	// 생산 요청 관리
	@RequestMapping("/podOrderAd")
	public String podOrderAd(Model model) {
		return "order/podOrderAd";
	}
	
	// 제품 안전 재고 관리
	@RequestMapping("/prdSfamtAd")
	public String prdSfamtAd(Model model) {
		return "order/prdSfamtAd";
	}
}
