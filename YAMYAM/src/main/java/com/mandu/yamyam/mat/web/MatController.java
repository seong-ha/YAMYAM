package com.mandu.yamyam.mat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MatController {

	@RequestMapping("/matOd")
	public String matOd(Model model) {
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
}
