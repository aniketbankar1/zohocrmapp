package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Contacts;

public interface ContactService {

	public void SaveOneContact(Contacts contact);

	public List<Contacts> getAllContacts();

	public Contacts getOneContact(long id);
}
