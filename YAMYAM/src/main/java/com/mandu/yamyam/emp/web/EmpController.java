package com.mandu.yamyam.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmpController {

	@RequestMapping("/emp")
	public String emp() {
		
		return "common/employeeAD";
	}
	
}
