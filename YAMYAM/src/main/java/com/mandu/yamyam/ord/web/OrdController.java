package com.mandu.yamyam.ord.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandu.yamyam.ord.service.OrdService;
import com.mandu.yamyam.ord.service.OrdVO;

@Controller
public class OrdController {
	
	@Autowired
	OrdService service;
	
	// 주문서 조회
	@GetMapping("ordList")
	@ResponseBody
	public List<OrdVO> getOrdList() {
		return service.getOrdList();
	}
	
	// 주문서 등록
	@PostMapping("/insertOrd")
	@ResponseBody
	public int insertOrd(@RequestBody List<OrdVO> vo) {
		System.out.println(1213);
		int result =  service.insertOrd(vo);
		System.out.println(result);
		return result;
	}
	
	// 주문서 선택삭제
	@DeleteMapping("deleteOrd")
	@ResponseBody
	public int deleteOrd(@RequestBody OrdVO vo) {
		int result = service.deleteOrd(vo);
		return result;
	}
	
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
