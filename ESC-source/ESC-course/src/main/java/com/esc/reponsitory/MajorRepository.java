package com.esc.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esc.entity.Major;

@Repository
public interface  MajorRepository extends JpaRepository<Major, Integer>{

	Major GetMajorByCode(@Param("MAJOR_CODE") String major_Code);
	
	int GetMaxIdMajor();
	
	List<Major> GetMajorByIndustry(@Param("INDUSTRY_ID") int industry_Id);
	
}
