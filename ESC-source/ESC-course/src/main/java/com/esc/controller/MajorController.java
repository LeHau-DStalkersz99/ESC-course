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

import com.esc.dto.MajorInsertDto;
import com.esc.dto.MajorUpdateDto;
import com.esc.entity.Major;
import com.esc.service.MajorService;

@RestController
@RequestMapping("api/major")
public class MajorController {

	@Autowired
	private MajorService majorService;

	@GetMapping("")
	public Object GetAllMajor() {
		List<Major> listMajor = majorService.GetAllMajor();
		if (listMajor.isEmpty()) {
			return new ResponseEntity<String>("[NULL] - List Major is null", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<Major>>(listMajor, HttpStatus.OK);
	}

	@GetMapping("/find/id/{major_Id}")
	public Object FindMajorById(@PathVariable("major_Id") int major_Id) {
		Major major = majorService.GetMajorById(major_Id);
		if (major != null) {
			return new ResponseEntity<Major>(major, HttpStatus.OK);
		}
		return new ResponseEntity<String>(major_Id + " not exist", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/find/code/{major_Code}")
	public Object FindMajorByCode(@PathVariable("major_Code") String major_Code) {
		Major major = majorService.GetMajorByCode(major_Code);
		if (major != null) {
			return new ResponseEntity<Major>(major, HttpStatus.OK);
		}
		return new ResponseEntity<String>(major_Code + " not exist", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/find-by-industry/{industry_Id}")
	public Object FindMajorByIndustry(@PathVariable("industry_Id") int industry_Id) {
		List<Major> listMajorByIndustry = majorService.GetMajorByIndustry(industry_Id);
		if (listMajorByIndustry != null) {
			return new ResponseEntity<List<Major>>(listMajorByIndustry, HttpStatus.OK);
		}
		return new ResponseEntity<String>("[NULL] - List major by industry is null", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add")
	public Object AddNewMajor(@RequestBody MajorInsertDto majorInsert) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			Major newEntity = modelMapper.map(majorInsert, Major.class);
			newEntity.setMAJOR_CODE("MJR00" + majorService.MaxIdMajor());
			majorService.SaveMajor(newEntity);
			return new ResponseEntity<Major>(newEntity, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{major_Id}")
	public Object UpdateMajor(@PathVariable("major_Id") int major_Id, @RequestBody MajorUpdateDto majorUpdate) {
		try {
			if (majorService.GetMajorById(major_Id) != null) {
				Major updateEntity = majorService.UpdateMajor(major_Id, majorUpdate);
				return new ResponseEntity<Major>(updateEntity, HttpStatus.OK);
			}
			return new ResponseEntity<String>(major_Id + " not exist", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
	}
}
