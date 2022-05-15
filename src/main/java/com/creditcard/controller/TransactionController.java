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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entities.Transaction;
import com.creditcard.exception.TransactionNotFoundException;
import com.creditcard.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/addtransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@PutMapping("/updatetransaction")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction1) {
		Transaction transaction = transactionService.updatetransaction(transaction1);
		if (transaction == null) {
			return new ResponseEntity("Sorry! Transaction not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@DeleteMapping("/transaction/{transactionId}")
	public ResponseEntity<String> deleteTransaction(@PathVariable("transactionId") Integer transactionId) {
		Boolean transaction = transactionService.deleteTransaction(transactionId);
		if (transaction == false) {
			return new ResponseEntity("Transaction deleted successfully", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Sorry! TransactionId not available!", HttpStatus.OK);
	}

	@GetMapping("/gettransaction/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Integer transactionId) {
		Transaction transaction = transactionService.getTransactionById(transactionId);
		if (transaction == null) {
			return new ResponseEntity("Sorry! transaction not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@GetMapping("/viewalltransaction")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		List<Transaction> transaction = transactionService.getAllTransactions();
		if (transaction.isEmpty()) {
			return new ResponseEntity("Sorry! transaction not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	}

	@GetMapping("/getalltransaction/{number}")
	public ResponseEntity<List<Transaction>> getAllTransaction1(@PathVariable("number") Long customercreditcardNumber)
			throws TransactionNotFoundException {
		List<Transaction> transaction = transactionService.getAllTransactionByCid(customercreditcardNumber);
		if (transaction.isEmpty()) {
			return new ResponseEntity("Sorry! transaction not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	}

}
