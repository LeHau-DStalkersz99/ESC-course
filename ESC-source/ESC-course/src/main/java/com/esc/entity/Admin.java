package com.esc.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AD_ID;
	
	private String AD_CODE;
	
	private String AD_FIRSTNAME;
	
	private String AD_LASTNAME;
	
	private LocalDate AD_DOB;
	
	private int AD_GENDER;
	
	private String AD_PHONE;
	
	private String AD_EMAIL;
	
	private String AD_ADDRESS;
	
	private String AD_AVARTAR;
	
	private String AD_USERNAME;
	
	private String AD_PASSWORD;
	
	private int AD_ROLE;
	
	private int AD_STATUS;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int aD_ID, String aD_CODE, String aD_FIRSTNAME, String aD_LASTNAME, LocalDate aD_DOB, int aD_GENDER,
			String aD_PHONE, String aD_EMAIL, String aD_ADDRESS, String aD_AVARTAR, String aD_USERNAME,
			String aD_PASSWORD, int aD_ROLE, int aD_STATUS) {
		super();
		AD_ID = aD_ID;
		AD_CODE = aD_CODE;
		AD_FIRSTNAME = aD_FIRSTNAME;
		AD_LASTNAME = aD_LASTNAME;
		AD_DOB = aD_DOB;
		AD_GENDER = aD_GENDER;
		AD_PHONE = aD_PHONE;
		AD_EMAIL = aD_EMAIL;
		AD_ADDRESS = aD_ADDRESS;
		AD_AVARTAR = aD_AVARTAR;
		AD_USERNAME = aD_USERNAME;
		AD_PASSWORD = aD_PASSWORD;
		AD_ROLE = aD_ROLE;
		AD_STATUS = aD_STATUS;
	}
}
