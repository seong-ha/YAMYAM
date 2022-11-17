package com.mandu.yamyam.mat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandu.yamyam.mat.service.MatOdService;


@Controller
public class MatController {

	@Autowired
	MatOdService service;
	
	@GetMapping("/matOd")
	public String matOd(Model model) {
		model.addAttribute("odList", service.matOrderList());		// 자재발주관리 리스트(일반 탭)
		model.addAttribute("matList", service.matList());			// 돋보기 자재목록 모달
		model.addAttribute("actList", service.actList());			// 돋보기 업체목록 모달
		model.addAttribute("needMatList", service.needMatList());	// 필요자재 리스트(생산계획 탭)
		model.addAttribute("newPlanList", service.newPlanList());	// 신규생산계획조회(생산계획서용 탭)
		model.addAttribute("addNewPlan", service.addNewPlan());		// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
		model.addAttribute("odMatList", service.odMatList());		// 자재발주 전체리스트(생산계획서용 탭)
		return "mat/matOd";
	}
	
	@RequestMapping("/matLookup")
	public String matLookup(Model model) {
		return "mat/matLookup";
	}
	
	@RequestMapping("/matInChk")
	public String matInChk(Model model) {
		return "mat/matInChk";
	}
	
	@RequestMapping("/matIn")
	public String matIn(Model model) {
		return "mat/matIn";
	}
	
	@RequestMapping("/matOut")
	public String matOut(Model model) {
		return "mat/matOut";
	}
	
	@RequestMapping("/matInOut")
	public String matInOut(Model model) {
		return "mat/matInOut";
	}
	
	@RequestMapping("/matStockLookup")
	public String matStockLookup(Model model) {
		return "mat/matStockLookup";
	}
	
	@RequestMapping("/matReturn")
	public String matReturn(Model model) {
		return "mat/matReturn";
	}
	
	@RequestMapping("/matReturnLookup")
	public String matReturnLookup(Model model) {
		return "mat/matReturnLookup";
	}
	
	@RequestMapping("/matSafe")
	public String matSafe(Model model) {
		return "mat/matSafe";
	}
}
