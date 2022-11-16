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
		model.addAttribute("odList", service.matOrderList());
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
