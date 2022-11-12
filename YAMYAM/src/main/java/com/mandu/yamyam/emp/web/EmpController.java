package com.mandu.yamyam.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandu.yamyam.emp.mapper.EmpMapper;


@Controller
public class EmpController {
	@Autowired
	EmpMapper dao;

	@RequestMapping("/list")
	public String empList(Model model) {
		model.addAttribute("empList", dao.getEmpList(null));
		return "emp/list";
	}
}
