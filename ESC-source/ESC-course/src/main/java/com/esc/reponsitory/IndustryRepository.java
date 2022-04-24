package com.esc.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esc.entity.Industry;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Integer>{
	
	Industry GetIndustryByCode (@Param("INDUSTRY_CODE") String industry_Code);
	
	int GetMaxIdIndustry();
}
