package com.creditcard.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="c_card")
public class CreditCard  {
	@Id
//	@GeneratedValue(strategy = Gene
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_SEQ") 
	@SequenceGenerator(sequenceName = "cardid_seq", allocationSize = 1, name = "CARD_SEQ")
	private int cardId;
	@Column(name="Type", unique=true)
	
	private String type;
	private int joiningfee;
	private int annulfee;
	private int limit;
//	private String bankName;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getJoiningfee() {
		return joiningfee;
	}
	public void setJoiningfee(int joiningfee) {
		this.joiningfee = joiningfee;
	}
	public int getAnnulfee() {
		return annulfee;
	}
	public void setAnnulfee(int annulfee) {
		this.annulfee = annulfee;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
//	public String getBankName() {
//		return bankName;
//	}
//	public void setBankName(String bankName) {
//		this.bankName = bankName;
//	}
	
	

	
	
}