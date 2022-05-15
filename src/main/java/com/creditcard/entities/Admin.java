package com.creditcard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String fName;
	private String lName;
	private String userName;
	private String password;
	private String mail;
	private long phNumber;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getNumber() {
		return phNumber;
	}

	public void setNumber(long number) {
		this.phNumber = number;
	}

	public Admin() {
		super();
	}

	public Admin(String fName, String lName, String userName, String password, String mail, long phnumber,
			int adminId) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.phNumber = phnumber;
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", fName=" + fName + ", lName=" + lName + ", userName=" + userName
				+ ", password=" + password + ", mail=" + mail + ", number=" + phNumber + "]";
	}

}
