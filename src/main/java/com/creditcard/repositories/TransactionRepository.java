package com.creditcard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
     @Query("select c from Transaction c where c.customerCreditCard.cardNumber=?1")
	List<Transaction> getTransactionByCustomer( Long customercreditcardnumber);


	





}
