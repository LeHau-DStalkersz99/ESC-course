package com.esc.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MajorUpdateDto {

	@NotBlank(message = "Nhap Ten Chuyen Nganh")
	private String MAJOR_NAME;

	@NotBlank(message = "Nhap Tinh Trang Chuyen Nganh")
	private int MAJOR_STATUS;
}
