package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Utilities.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailservice;

	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to") String to,@RequestParam("sub") String subject,@RequestParam("emailBody") String emailBody){
		emailservice.sendEmail(to, subject, emailBody);
		return "compose_email";
	}
}
