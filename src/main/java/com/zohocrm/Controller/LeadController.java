package com.zohocrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Contacts;
import com.zohocrm.Entities.Lead;
import com.zohocrm.Services.ContactService;
import com.zohocrm.Services.LeadService;

@Controller
public class LeadController {
	@Autowired 
	private LeadService leadservice;
	@Autowired
	private ContactService contactservice;
	@RequestMapping("/viewLeadPage")
	public String viewLeadPage() {
		return "create_lead";
	}
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute ("lead") Lead lead,ModelMap model) {
		leadservice.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email") String email,ModelMap model) {
		model.addAttribute("email",email);	
		return "compose_email";
		}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam ("id") long id,ModelMap model) {
		Lead lead = leadservice.getOneLead(id);
		Contacts contact= new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactservice.SaveOneContact(contact);
		leadservice.deleteOneLead(lead.getId());
		List<Contacts> contacts=contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		}
	@RequestMapping("/listall")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads=leadservice.listLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		}
	@RequestMapping("/findLeadById")
	public String findOneLead(@RequestParam ("id")long id,ModelMap model) {
		Lead lead = leadservice.getOneLead(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		} 
}