package com.ori98.jpawebsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ori98.jpawebsite.model.Avenger;

public interface AvengerRepo extends JpaRepository<Avenger, Integer>{
	// not defining our own implementations
	
	// implementation for complex queries
	List<Avenger> findByaPower(String aPower);
	// greater than/ less than
	List<Avenger> findByaIdGreaterThan(int start);
	// finding by power but in sorted order
	@Query("from Avenger where avenger_power =?1 order by aId desc")
	List<Avenger> findByaPowerSorted(String aPower);
}
