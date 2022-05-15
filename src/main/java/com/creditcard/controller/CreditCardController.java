package com.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entities.CreditCard;
import com.creditcard.service.CreditCardService;

@RestController
@RequestMapping("/api/creditcard")
@CrossOrigin(origins = "http://localhost:3000/")

public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@PostMapping("/addcreditcard")
	public CreditCard addCreditCard(@RequestBody CreditCard creditcard) {
		return creditCardService.addCreditCard(creditcard);
	}

	@GetMapping("/getAll")
	public List<CreditCard> getCreditcards() {
		return creditCardService.getCreditCardList();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CreditCard> getCreditcard(@PathVariable("id") Integer creditcardId) {
		CreditCard creditcard = creditCardService.getCreditCardById(creditcardId);
		if (creditcard == null) {
			return new ResponseEntity("Sorry! Creditcard not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CreditCard>(creditcard, HttpStatus.OK);
	}

	@GetMapping("/getBytype/{cardtype}")
	public ResponseEntity<Object> getCreditCardByType(@PathVariable("cardtype") String cardtype) {
		CreditCard creditcard = creditCardService.getCreditCardByType(cardtype);
		if (creditcard == null) {
			return new ResponseEntity<>("Sorry! Creditcard not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(creditcard, HttpStatus.OK);
	}

	@DeleteMapping("/creditcard/{cardId}")
	public ResponseEntity<String> deleteCreditCard(@PathVariable("cardId") Integer cardId) {
		creditCardService.deletecreditcard(cardId);

		return new ResponseEntity<String>("CreditCard deleted sucussfully!", HttpStatus.OK);
	}

}