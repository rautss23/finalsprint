package com.creditcard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.CustomerCreditCard;

@Repository
public interface CustomerCreditCardRepository extends JpaRepository<CustomerCreditCard, Long>{
  


	
}
