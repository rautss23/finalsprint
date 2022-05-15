package com.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entities.CustomerCreditCard;
import com.creditcard.service.CustomerCreditCardService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerCreditcardController {
	@Autowired
	CustomerCreditCardService customercreditcardService;

	@PostMapping("/addcard")
	public CustomerCreditCard addCustomerCreditCard(@RequestBody CustomerCreditCard customercreditcard) {
		return customercreditcardService.addCustomerCreditCard(customercreditcard);
	}

}