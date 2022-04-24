package com.esc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esc.dto.IndustryInsertAndUpdateDto;
import com.esc.entity.Industry;
import com.esc.reponsitory.IndustryRepository;

@Service
public class IndustryService {

	@Autowired
	private IndustryRepository industryRepository;

	public List<Industry> GetAllIndustry() {
		return industryRepository.findAll();
	}

	public Industry GetIndustryById(int industry_Id) {
		return industryRepository.findById(industry_Id).orElse(null);
	}

	public Industry GetIndustryByCode(String industry_Code) {
		return industryRepository.GetIndustryByCode(industry_Code);
	}

	public int MaxIdIndustry() {
		try {
			return industryRepository.GetMaxIdIndustry();
		} catch (Exception e) {
			int maxID = 1;
			return maxID;
		}
	}

	public Industry SaveIndustry(Industry insudtryInsert) {
		return industryRepository.save(insudtryInsert);
	}

	public Industry UpdateIndustry(int industry_Id, IndustryInsertAndUpdateDto industryUpdate) {
		Industry industryCheckExist = industryRepository.findById(industry_Id).orElse(null);
		if (industryCheckExist != null) {
			industryCheckExist.setINDUSTRY_NAME(industryUpdate.getINDUSTRY_NAME());
			industryCheckExist.setINDUSTRY_STATUS(industryUpdate.getINDUSTRY_STATUS());
			return industryRepository.save(industryCheckExist);
		}
		return null;
	}
}
