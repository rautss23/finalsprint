package com.creditcard.service;

import java.util.List;

import com.creditcard.entities.CreditCard;

public interface CreditCardService {

	List<CreditCard> getCreditCardList();

	public CreditCard addCreditCard(CreditCard creditcard);

	CreditCard getCreditCardById(Integer creditcardId);

	CreditCard getCreditCardByType(String cardType);

	void deletecreditcard(Integer cardId);

}
