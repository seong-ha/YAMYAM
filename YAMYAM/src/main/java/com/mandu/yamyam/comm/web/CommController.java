package com.mandu.yamyam.comm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandu.yamyam.comm.service.CommService;


@Controller
public class CommController {

	@Autowired
	CommService service;
	
	@RequestMapping("/employeeAD")
	public String employeeAD(Model model) {
		model.addAttribute("depts", service.selectDept());
		model.addAttribute("jobs", service.selectCommCode("JOB-GRD"));
		return "comm/employeeAD";
	}
	
	@RequestMapping("/commonCodeAD")
	public String commonCodeAD() {
		
		return "comm/commCodeAD";
	}
	
	@RequestMapping("/matCodeAD")
	public String matCodeAD() {
		
		return "comm/matCodeAD";
	}
	
	@RequestMapping("/actCodeAD")
	public String actCodeAD() {
		
		return "comm/actCodeAD";
	}
	
	@RequestMapping("/pdtCodeAD")
	public String pdtCodeAD() {
		
		return "comm/pdtCodeAD";
	}
	
	@RequestMapping("/BOMAD")
	public String emp() {
		
		return "comm/BOMAD";
	}
	
	
	
}
