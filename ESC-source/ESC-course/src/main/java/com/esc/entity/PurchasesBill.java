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
@Table(name = "purchasesbill")
public class PurchasesBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PURCHASESBILL_ID;
	
	private String PURCHASESBILL_CODE;
	
	private LocalDate PURCHASESBILL_CREATEDAY;
	
	private String PURCHASESBILL_NOTE;
	
	private float PURCHASESBILL_TOTALMONEY;
	
	private int PURCHASESBILL_STATUS;
	
	private int PAYM_ID;
	
	private int STUDENT_ID;
	
}
