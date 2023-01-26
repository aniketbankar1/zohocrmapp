package com.zohocrm.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entities.Contacts;
import com.zohocrm.Repositories.ContactsRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactsRepository contactRepo;
	
	@Override
	public void SaveOneContact(Contacts contact) {
		
		contactRepo.save(contact);
	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contacts getOneContact(long id) {
		Optional<Contacts> findById = contactRepo.findById(id);
		Contacts contacts = findById.get();
		return contacts;
		
	}

}
