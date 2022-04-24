package com.esc.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class IndustryInsertAndUpdateDto {

	@NotBlank(message = "Nhap Ten Nganh")
	private String INDUSTRY_NAME;
	
	@NotBlank(message = "Nhap Tinh Trang Nganh")
	private int INDUSTRY_STATUS;
}
