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
@Table(name = "majors")

@NamedQueries({
		@NamedQuery(name = "Major.GetMajorByCode", query = "SELECT mjr FROM Major mjr WHERE mjr.MAJOR_CODE = :MAJOR_CODE"),
		@NamedQuery(name = "Major.GetMaxIdMajor", query = "SELECT MAX(mjr.MAJOR_ID) FROM Major mjr"),
		@NamedQuery(name = "Major.GetMajorByIndustry", query = "SELECT mjr FROM Major mjr WHERE mjr.INDUSTRY_ID = :INDUSTRY_ID"), })

public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MAJOR_ID;

	private String MAJOR_CODE;

	private String MAJOR_NAME;

	@CreationTimestamp
	private LocalDate MAJOR_CREATEDAY;

	private int MAJOR_STATUS;

	private int INDUSTRY_ID;

}
