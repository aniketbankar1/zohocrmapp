package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Billing;
import com.zohocrm.Entities.Contacts;
import com.zohocrm.Services.BillingService;
import com.zohocrm.Services.ContactService;

@Controller
public class BillingController {

	@Autowired 
	private BillingService billingservice;
	
	@Autowired 
	private ContactService contactservice;
	
	@RequestMapping("/generateBill")
	public String getContactId(@RequestParam("id") long id, ModelMap model) {
		Contacts contact=contactservice.getOneContact(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
	@RequestMapping("/saveBill")	
	public String saveBill(@ModelAttribute("bill") Billing bill){
		billingservice.saveBil(bill);
		return "generate_bill";
	}
}
