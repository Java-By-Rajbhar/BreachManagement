package com.maggie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maggie.app.entity.Breach;

public interface BreachRepository extends JpaRepository<Breach, Long> {

	Breach findByBreachId(Long breachId);

}
