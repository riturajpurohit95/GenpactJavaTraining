package com.springboot.first_webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;

@Controller
public class FormController {
	
	//@Controller
	//- tells spring boot that this class will handle the web requests
	//- making a get request
	
	@GetMapping("/form")    //annotating below method - method will handle get request to url /form
	public String showForm() {
		return "redirect:/form.html";  //tell spring to redirect user's browser to static html file - form.html
	}
	
	//handle form
//	@PostMapping("/submit")  //handle http post request to /submit
//	@ResponseBody            //return value of method should be written directly to http response bosy
//	public String handleForm(
//			@RequestParam String name, 
//			@RequestParam String email,
//			@RequestParam int age) {
//		//name field value - extracted in String name
//		
//		return "<h3> Form Submitted Successfully.</h3>"
//				+ "<p> Name: "+name
//				+ ", Email: "+email
//				+ ", Age: "+age+"</p>"
//				+ "<a href='/form'> Go back </a>";
//	}
	
	//submitted data - prevent duplicate entry
	@PostMapping("/submit")
//	@ResponseBody
	public String handleFormRedirect(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age,
			RedirectAttributes redirectAttributes) {
		//keep values same when they are put in url
		
		String safeName = HtmlUtils.htmlEscape(name==null?"":name);
		String safeEmail = HtmlUtils.htmlEscape(email==null?"":email);
		String safeAge = Integer.toString(age);
		
		redirectAttributes.addAttribute("name",safeName);
		redirectAttributes.addAttribute("email",safeEmail);
		redirectAttributes.addAttribute("age",safeAge);
		
		return "redirect:/result";
	}
	
	//show submitted data in result
	@GetMapping("/result")
	@ResponseBody
	public String showResult(
			@RequestParam(required=false, defaultValue="") String name,
			@RequestParam(required=false, defaultValue="") String email,
			@RequestParam(required=false, defaultValue="") String age)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>Result</title></head><body>");
		sb.append("<h2>Submission Result</h2>");
		sb.append("<p>Name:").append(name).append("</p>");
		sb.append("<p>Email:").append(email).append("</p>");
		sb.append("<p>Age:").append(age).append("</p>");
		sb.append("<p><a href='/form.html'>Submit Another Form</a></p>");
		sb.append("<p><a href='/'>Back to Index</a></p>");
		sb.append("</body></html>");
		
		return sb.toString();
	}
	
	//user opens form - controller redirects - /form.html - user fill and submit ->
	//										- post /submit - handleFormRedirect execute ->
	//										-  spring add params - redirect /result
	//										- get request /result  - call showResultController
	//										- display html page

}
