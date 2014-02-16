package org.geeksexception.web.controller;

import javax.inject.Inject;

import org.geeksexception.web.model.Concern;
import org.geeksexception.web.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Inject
	private MailService mailService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String contact(Model model) {
		
		model.addAttribute("concern", new Concern());
		
		return "contact";
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String sendConcern(Model model, Concern concern) {
		
		mailService.sendConcern(concern);
		model.addAttribute("concern", new Concern());
		model.addAttribute("info", concern);
		
		return "contact";
		
	}
	
}