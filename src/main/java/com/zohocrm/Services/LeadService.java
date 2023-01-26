package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Lead;

public interface LeadService {


public void saveOneLead(Lead lead);

public Lead getOneLead(long id);

public void deleteOneLead(long id);

public List<Lead> listLeads();
}
