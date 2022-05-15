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

import com.creditcard.entities.Transaction;
import com.creditcard.exception.TransactionNotFoundException;
import com.creditcard.repositories.TransactionRepository;
import com.creditcard.service.TransactionService;
@SpringBootTest
class TransactionTest {

	@Autowired
	TransactionService transactionService;
	@MockBean
	TransactionRepository transactionReposity;
	Transaction transaction;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		transaction = new Transaction();
		transaction.getTransactionId();
		transaction.getTransactiondate();
		transaction.getAmount();
		transaction.getStatus();
//transaction.getUser();
		transaction.getCustomerCreditCard();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Mockito.when(transactionReposity.save(transaction)).thenReturn(transaction);
		assertThat(transactionService.addTransaction(transaction));

	}

	@Test
	void testGetMovieShow() throws TransactionNotFoundException {
		ArrayList showList = new ArrayList();

		Mockito.when(transactionReposity.findAll()).thenReturn(showList);
		assertThat(transactionService.getAllTransactions()).isEqualTo(showList);

	}

}
