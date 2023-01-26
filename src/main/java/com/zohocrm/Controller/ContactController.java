package com.zohocrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.Entities.Contacts;
import com.zohocrm.Services.ContactService;

@Controller
public class ContactController {

	@Autowired 
	private ContactService contactservice;  
	
	@RequestMapping("/listContacts")
	public String listContacts(ModelMap model) {
		List<Contacts> contacts=contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
}
