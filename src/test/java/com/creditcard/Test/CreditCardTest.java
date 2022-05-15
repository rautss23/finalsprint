package com.creditcard.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.creditcard.entities.CreditCard;
import com.creditcard.exception.CreditCardNotFoundException;
import com.creditcard.repositories.CreditCardRepository;
import com.creditcard.service.CreditCardService;
@SpringBootTest
class CreditCardTest {

	@Autowired
	CreditCardService creditcardService;
	@MockBean
	CreditCardRepository creditcardReposity;
	CreditCard creditcard;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	

	@BeforeEach
	void setUp() throws Exception {
		creditcard = new CreditCard();
		creditcard.getAnnulfee();
//creditcard.getBankName();
		creditcard.getCardId();
		creditcard.getJoiningfee();
		creditcard.getLimit();
//creditcard.getName();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Mockito.when(creditcardReposity.save(creditcard)).thenReturn(creditcard);
		assertThat(creditcardService.addCreditCard(creditcard));

	}

	@Test
	void testGetMovieShow() throws CreditCardNotFoundException {
		ArrayList showList = new ArrayList();

		Mockito.when(creditcardReposity.findAll()).thenReturn(showList);
		assertThat(creditcardService. getCreditCardList()).isEqualTo(showList);

	}

}
