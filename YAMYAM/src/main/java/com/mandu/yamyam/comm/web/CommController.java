package com.mandu.yamyam.comm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.EmpVO;


@Controller
public class CommController {

	@Autowired
	CommService commservice;

	
	@RequestMapping("/employeeAD")
	public String employeeAD(Model model) {
		model.addAttribute("depts", commservice.selectDept());
		model.addAttribute("jobs", commservice.selectCommCode("JOB-GRD"));
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
	
	// ajax 전체 조회
	@GetMapping("ajax/selectEmp")
	@ResponseBody
	public List<EmpVO> ajaxSelectAllEmp() {
		
		return commservice.ajaxSelectAllEmp();
	}
	
}
