package com.creditcard.service;

import com.creditcard.repositories.CustomerCreditCardRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.entities.CustomerCreditCard;

@Service
public class CustomerCreditCardServiceImpl implements CustomerCreditCardService {

	@Autowired
	CustomerCreditCardRepository customerCreditCardRepo;

	@Override
	@Transactional
	public CustomerCreditCard addCustomerCreditCard(CustomerCreditCard customercreditcard) {
		return customerCreditCardRepo.save(customercreditcard);
	}

	@Override
	public List<CustomerCreditCard> getCustomerCreditCard() {
		return customerCreditCardRepo.findAll();
	}

}
