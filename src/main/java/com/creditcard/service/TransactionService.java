package com.creditcard.service;

import java.util.List;
import com.creditcard.entities.Transaction;

public interface TransactionService {

	Transaction addTransaction(Transaction transaction);

	Transaction getTransactionById(Integer transactionId);

	List<Transaction> getAllTransactions();

	List<Transaction> getAllTransactionByCid(Long customercreditcardNumber);

	Transaction updatetransaction(Transaction transaction1);

	boolean deleteTransaction(Integer transactionId);

}
