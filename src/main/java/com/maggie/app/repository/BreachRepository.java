package com.maggie.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maggie.app.entity.Breach;
/**
 * @author Sushil
 * 
 */
@Repository
public interface BreachRepository extends JpaRepository<Breach, Long> {


	Breach findByBreachId(Long breachId);


	/**
	 * 
	 * @param riskType
	 * @return List<Breach>
	 */
	public List<Breach> findByRiskType(String riskType);
	
	/**
	 * 
	 * @param status
	 * @return List<Breach>
	 */
	public List<Breach> findByStatus(String status);
}
