package com.creditcard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.entities.Transaction;
import com.creditcard.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Transactional
	@Override
	public Transaction addTransaction(Transaction transaction) {

		return transactionRepo.save(transaction);
	}

	@Override
	public Transaction getTransactionById(Integer transactionId) {

		return transactionRepo.getById(transactionId);
	}

	@Override
	public List<Transaction> getAllTransactions() {

		return transactionRepo.findAll();
	}

	@Override
	public List<Transaction> getAllTransactionByCid(Long customercreditcardNumber) {

		return transactionRepo.getTransactionByCustomer(customercreditcardNumber);
	}

	@Override
	public Transaction updatetransaction(Transaction transaction1) {

		return transactionRepo.save(transaction1);
	}

	@Override
	public boolean deleteTransaction(Integer transactionId) {

		transactionRepo.deleteById(transactionId);
		Transaction u1 = transactionRepo.getById(transactionId);
		if (u1 == null) {
			return true;
		}
		return false;
	}

}
