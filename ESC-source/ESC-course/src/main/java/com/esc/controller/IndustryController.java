package com.esc.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esc.dto.IndustryInsertAndUpdateDto;
import com.esc.entity.Industry;
import com.esc.service.IndustryService;

@RestController
@RequestMapping("api/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;

	@GetMapping("")
	public Object GetAllIndustry() {
		List<Industry> listIndustry = industryService.GetAllIndustry();
		if (listIndustry.isEmpty()) {
			return new ResponseEntity<String>("[NULL] - List Insdustry is null", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Industry>>(listIndustry, HttpStatus.OK);
	}

	@GetMapping("/find/id/{industry_Id}")
	public Object FindIndustryById(@PathVariable("industry_Id") int industry_Id) {
		Industry industry = industryService.GetIndustryById(industry_Id);
		if (industry != null) {
			return new ResponseEntity<Object>(industry, HttpStatus.OK);
		}
		return new ResponseEntity<String>(industry_Id + " Not exist", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/find/code/{industry_Code}")
	public Object FindIndustryByCode(@PathVariable("industry_Code") String industry_Code) {
		Industry industry = industryService.GetIndustryByCode(industry_Code);
		if (industry != null) {
			return new ResponseEntity<Object>(industry, HttpStatus.OK);
		}
		return new ResponseEntity<String>(industry_Code + " Not exist", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add")
	public Object AddNewIndustry(@RequestBody IndustryInsertAndUpdateDto industryInsert) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			Industry newEntity = modelMapper.map(industryInsert, Industry.class);
			newEntity.setINDUSTRY_CODE("IDT00" + industryService.MaxIdIndustry());
			industryService.SaveIndustry(newEntity);
			return new ResponseEntity<Industry>(newEntity, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{industry_Id}")
	public Object UpdateIndustry(@PathVariable("industry_Id") int industry_Id,
			@RequestBody IndustryInsertAndUpdateDto industryUpdate) {
		try {
			if(industryService.GetIndustryById(industry_Id) != null) {
				Industry updateEntity = industryService.UpdateIndustry(industry_Id, industryUpdate);
				return new ResponseEntity<Industry>(updateEntity, HttpStatus.OK);
			}
			return new ResponseEntity<String>(industry_Id + " Not exist", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
	}
}
