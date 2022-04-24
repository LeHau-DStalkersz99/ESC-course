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
@Table(name = "videos")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int VIDEO_ID;
	
	private String VIDEO_CODE;
	
	private String VIDEO_NAME;
	
	private String VIDEO_DESCRIPTION;
	
	private LocalDate VIDEO_CREATEDAY;
	
	private String VIDEO_URL;
	
	private int VIDEO_STATUS;
	
	private int TOPIC_ID;
	
}
