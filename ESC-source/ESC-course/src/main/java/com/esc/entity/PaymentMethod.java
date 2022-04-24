package com.esc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "paymentmethods")
public class PaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PAYM_ID;

	private String PAYM_NAME;

	private String PAYM_NOTE;

	private String PAYM_STATUS;
}
