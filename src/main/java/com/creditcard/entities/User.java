package com.creditcard.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer")
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ") 
	@SequenceGenerator(sequenceName = "userid_seq", allocationSize = 1, name = "USER_SEQ")
	@Column(name="userId",nullable=false)
	private int userId;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name="lName")
	private String lName;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="phNumber")
	private Long phNumber;
	
	
	private String village;
	private String city;
	private String state;
	private int pincode;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="income")
	private Integer income;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="education")
	private String education;
	private LocalDate dob;
	
	private String role;
	
	

	@JsonIgnore
	@OneToOne(mappedBy="user")
	private CustomerCreditCard customerCreditCard;



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}






	public Long getPhNumber() {
		return phNumber;
	}



	public void setPhNumber(Long phNumber) {
		this.phNumber = phNumber;
	}



	public String getVillage() {
		return village;
	}



	public void setVillage(String village) {
		this.village = village;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getPincode() {
		return pincode;
	}



	public void setPincode(int pincode) {
		this.pincode = pincode;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	


	public Integer getIncome() {
		return income;
	}



	public void setIncome(Integer income) {
		this.income = income;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public CustomerCreditCard getCustomerCreditCard() {
		return customerCreditCard;
	}



	public void setCustomerCreditCard(CustomerCreditCard customerCreditCard) {
		this.customerCreditCard = customerCreditCard;
	}


	
	
	
}