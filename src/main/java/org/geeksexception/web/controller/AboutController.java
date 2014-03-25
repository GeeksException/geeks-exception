package org.geeksexception.web.controller;

import javax.inject.Inject;

import org.geeksexception.web.model.Concern;
import org.geeksexception.web.service.MailService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@Inject
	private MailService mailService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String contact() { return "about"; }
	
	@RequestMapping(value="/send", method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Concern sendConcern(@RequestBody Concern concern) {
		
		mailService.sendConcern(concern);
		
		return concern;
		
	}
	
}