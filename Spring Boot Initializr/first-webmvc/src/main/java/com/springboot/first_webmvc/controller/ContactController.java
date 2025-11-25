package com.springboot.first_webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	@GetMapping("/contact")   
	public String showcontact() {
		return "redirect:/contact.html"; 
	}

}
