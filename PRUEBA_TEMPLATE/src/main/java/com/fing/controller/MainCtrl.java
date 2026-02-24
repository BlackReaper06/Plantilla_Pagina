package com.fing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {
	
	
	
	@GetMapping("/")
	public String raiz(Model model) {
		model.addAttribute("msg","Holaaa");
		return "index";
		
	}

}

