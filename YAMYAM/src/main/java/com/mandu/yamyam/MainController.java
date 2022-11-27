package com.mandu.yamyam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// 첫 화면
	@RequestMapping("/main")
	public String main(Model model) {
		return "layout/main";
	}
	
	@RequestMapping("/")
	public String login(Model model) {
		return "login";
	}
}
