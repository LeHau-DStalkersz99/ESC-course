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
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int COURSE_ID;

	private String COURSE_CODE;

	private String COURSE_NAME;

	private String COURSE_DESCRIPTION;

	private String COURSE_AUTHOR;
	
	private LocalDate COURSE_CREATEDAY;

	private LocalDate COURSE_LASTUPDATE;

	private String COURSE_PICTURE;

	private Float COURSE_PRICE;
	
	private int COURSE_STATUS;

	private int MAJOR_ID;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int cOURSE_ID, String cOURSE_CODE, String cOURSE_NAME, String cOURSE_DESCRIPTION,
			String cOURSE_AUTHOR, LocalDate cOURSE_CREATEDAY, LocalDate cOURSE_LASTUPDATE, String cOURSE_PICTURE,
			Float cOURSE_PRICE, int cOURSE_STATUS, int mAJOR_ID) {
		super();
		COURSE_ID = cOURSE_ID;
		COURSE_CODE = cOURSE_CODE;
		COURSE_NAME = cOURSE_NAME;
		COURSE_DESCRIPTION = cOURSE_DESCRIPTION;
		COURSE_AUTHOR = cOURSE_AUTHOR;
		COURSE_CREATEDAY = cOURSE_CREATEDAY;
		COURSE_LASTUPDATE = cOURSE_LASTUPDATE;
		COURSE_PICTURE = cOURSE_PICTURE;
		COURSE_PRICE = cOURSE_PRICE;
		COURSE_STATUS = cOURSE_STATUS;
		MAJOR_ID = mAJOR_ID;
	}
}
