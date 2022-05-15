package com.creditcard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.CreditCard;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
    @Query("select c from CreditCard c where c.type=ctype")
	CreditCard getByType(@Param("ctype") String name);

    @Query("select c.type from CreditCard c")
    List<String> getAllCardTypes();



}
