package com.esc.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "industrys")

@NamedQueries({
	@NamedQuery(name = "Industry.GetIndustryByCode", query = "SELECT idt FROM Industry idt WHERE idt.INDUSTRY_CODE = :INDUSTRY_CODE"),
	@NamedQuery(name = "Industry.GetMaxIdIndustry", query = "SELECT MAX(idt.INDUSTRY_ID) FROM Industry idt"),
})


public class Industry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int INDUSTRY_ID;

	private String INDUSTRY_CODE;
	
	private String INDUSTRY_NAME;
	
	@CreationTimestamp
	private LocalDate INDUSTRY_CREATEDAY;
	
	private int INDUSTRY_STATUS;
	
}
