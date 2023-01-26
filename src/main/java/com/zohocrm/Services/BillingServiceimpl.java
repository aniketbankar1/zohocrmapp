package com.zohocrm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entities.Billing;
import com.zohocrm.Repositories.BillingRepository;
@Service
public class BillingServiceimpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;
	
	@Override
	public void saveBil(Billing bill) {
		billingRepo.save(bill);
	}

}
