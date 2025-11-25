package com.springboot.first_webmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.first_webmvc.model.User;

@Controller
public class FormTagController {
	
	@GetMapping("/formTag")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		
		//options for multiple checkboxes
		List<String> interestsOptions = Arrays.asList("Sprots","Travalling","Reading","Music");
		model.addAttribute("interestsOptions",interestsOptions);
		
		List<String> countries = Arrays.asList("India","America","Japan","China");
		model.addAttribute("countries",countries);
		
		List<String> languageOptions = Arrays.asList("English","Hindi","Punjabi","Marwadi");
		model.addAttribute("languageOptions",languageOptions);
		return "formTag";
	}
	
	@PostMapping("/formTag")
	public String submitForm(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user",user);
		return "result";
	}

}
