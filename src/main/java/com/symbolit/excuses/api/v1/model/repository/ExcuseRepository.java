package com.symbolit.excuses.api.v1.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbolit.excuses.api.v1.model.entity.Excuse;

@Repository
public interface ExcuseRepository extends JpaRepository<Excuse, Long >{
	
	Optional<Excuse> findByHttpCode(int httpCode);
	
}
