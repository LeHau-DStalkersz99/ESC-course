package com.esc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "detailpurchasesbill")
public class DetailPurchasesBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DPB_ID;

	private int PURCHASESBILL_ID;

	private int COURSE_ID;

	private float DPB_PRICE;

	private String DPB_NOTE;


}
