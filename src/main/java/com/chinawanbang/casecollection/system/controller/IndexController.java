package com.chinawanbang.casecollection.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "/", "" })
	String welcome(Model model) {
		return "redirect:/user/index";
	}
}
