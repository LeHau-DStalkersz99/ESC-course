package com.esc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esc.dto.MajorUpdateDto;
import com.esc.entity.Major;
import com.esc.reponsitory.MajorRepository;

@Service
public class MajorService {

	@Autowired
	private MajorRepository majorReponsitory;

	public List<Major> GetAllMajor() {
		return majorReponsitory.findAll();
	}

	public Major GetMajorById(int major_Id) {
		return majorReponsitory.findById(major_Id).orElse(null);
	}

	public Major GetMajorByCode(String major_Code) {
		return majorReponsitory.GetMajorByCode(major_Code);
	}

	public List<Major> GetMajorByIndustry(int industry_Id) {
		return majorReponsitory.GetMajorByIndustry(industry_Id);
	}

	public int MaxIdMajor() {
		try {
			return majorReponsitory.GetMaxIdMajor();
		} catch (Exception e) {
			int maxId = 1;
			return maxId;
		}
	}

	public Major SaveMajor(Major majorInsert) {
		return majorReponsitory.save(majorInsert);
	}

	public Major UpdateMajor(int major_Id, MajorUpdateDto majorUpdate) {
		Major findExistMajor = majorReponsitory.findById(major_Id).orElse(null);
		if (findExistMajor != null) {
			findExistMajor.setMAJOR_NAME(majorUpdate.getMAJOR_NAME());
			findExistMajor.setMAJOR_STATUS(majorUpdate.getMAJOR_STATUS());
			return majorReponsitory.save(findExistMajor);
		}
		return null;
	}
}
