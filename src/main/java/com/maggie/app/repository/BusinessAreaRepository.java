package com.maggie.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maggie.app.entity.BusinessArea;

public interface BusinessAreaRepository extends JpaRepository<BusinessArea, Long> {

	List<BusinessArea> findByFranchiseFranchiseId(Long id);
	
}
