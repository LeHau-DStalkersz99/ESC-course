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
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int STUDENT_ID;

	private String STUDENT_CODE;

	private String STUDENT_FIRSTNAME;

	private String STUDENT_LASTNAME;

	private int STUDENT_GENDER;

	private String STUDENT_PHONE;

	private String STUDENT_EMAIL;

	private String STUDENT_PASSWORD;

	private LocalDate STUDENT_DOB;

	private String STUDENT_ADDRESS;

	private String STUDENT_AVATAR;

	private LocalDate STUDENT_CREATEDAY;

	private int STUDENT_STATUS;
}
