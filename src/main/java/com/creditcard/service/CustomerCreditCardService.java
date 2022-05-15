package com.creditcard.service;

import java.util.List;

import com.creditcard.entities.CustomerCreditCard;

public interface CustomerCreditCardService {

	public CustomerCreditCard addCustomerCreditCard(CustomerCreditCard customercreditcard);

	List<CustomerCreditCard> getCustomerCreditCard();

}
