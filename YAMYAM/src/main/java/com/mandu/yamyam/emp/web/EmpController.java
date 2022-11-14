package com.mandu.yamyam.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmpController {

	@RequestMapping("/employeeAD")
	public String employeeAD() {
		
		return "common/employeeAD";
	}
	
	@RequestMapping("/commonCodeAD")
	public String commonCodeAD() {
		
		return "common/commonCodeAD";
	}
	
	@RequestMapping("/matCodeAD")
	public String matCodeAD() {
		
		return "common/matCodeAD";
	}
	
	@RequestMapping("/actCodeAD")
	public String actCodeAD() {
		
		return "common/actCodeAD";
	}
	
	@RequestMapping("/pdtCodeAD")
	public String pdtCodeAD() {
		
		return "common/pdtCodeAD";
	}
	
	@RequestMapping("/BOMAD")
	public String emp() {
		
		return "common/BOMAD";
	}
	
	
	
}
