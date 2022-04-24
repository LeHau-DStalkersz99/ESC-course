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
@Table(name = "topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TOPIC_ID;

	private String TOPIC_CODE;
	
	private String TOPIC_NAME;
	
	private String TOPIC_DESCRIPTION;
	
	private LocalDate TOPIC_CREATEDAY;
	
	private int TOPIC_STATUS;
	
	private int COURSE_ID;

}
