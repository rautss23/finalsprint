package com.creditcard.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customer_card")
public class CustomerCreditCard {
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_CARD_SEQ")
	@SequenceGenerator(sequenceName = "cardnumber_seq", allocationSize = 1, name = "CUSTOMER_CARD_SEQ")
	private long cardNumber;
	private LocalDate fDate;
	private LocalDate toDate;
	private int code;
	private String name;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@JsonBackReference
	@OneToMany(mappedBy = "customerCreditCard")
	private List<Transaction> transactions;

	@OneToOne
	@JoinColumn(name = "cardId")
	private CreditCard creditCard;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getfDate() {
		return fDate;
	}

	public void setfDate(LocalDate fDate) {
		this.fDate = fDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
