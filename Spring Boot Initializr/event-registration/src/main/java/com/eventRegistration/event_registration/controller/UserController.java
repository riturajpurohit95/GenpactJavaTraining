package com.eventRegistration.event_registration.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventRegistration.event_registration.model.User;

import jakarta.validation.Valid;


@Controller
public class UserController {
	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		
		List<String> technologiesOptions = Arrays.asList("Java","Python","AI","ML");
		model.addAttribute("technologiesOptions",technologiesOptions);
		
		List<String> sessionsOptions = Arrays.asList("Morning Session - 11:00","Afternoon Session - 1:00","Afternoon session - 12:00");
		model.addAttribute("sessionsOptions",sessionsOptions);
		
		List<String> paymentOptions = Arrays.asList("upi","debit card","credit card");
		model.addAttribute("paymentOptions",paymentOptions);
		
		return "register";
	}
	
	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
		model.addAttribute("user",user);
		
		List<String> technologiesOptions = Arrays.asList("Java","Python","AI","ML");
		model.addAttribute("technologiesOptions",technologiesOptions);
		
		List<String> sessionsOptions = Arrays.asList("Morning Session - 11:00","Afternoon Session - 1:00","Afternoon session - 12:00");
		model.addAttribute("sessionsOptions",sessionsOptions);
		
		List<String> paymentOptions = Arrays.asList("upi","debit card","credit card");
		model.addAttribute("paymentOptions",paymentOptions);
		
		if(result.hasErrors()) {
			return "register";
		}
		
		return "summary";
	}

}