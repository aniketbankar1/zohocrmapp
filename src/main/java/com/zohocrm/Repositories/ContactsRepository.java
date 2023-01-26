package com.zohocrm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm.Entities.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts,Long> {

}
