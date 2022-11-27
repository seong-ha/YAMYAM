package com.mandu.yamyam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// 첫 화면, 로그인 후 첫화면
	@RequestMapping("/")
	public String main(Model model) {
		return "layout/main";
	}
	
	// 로그인 화면으로
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
