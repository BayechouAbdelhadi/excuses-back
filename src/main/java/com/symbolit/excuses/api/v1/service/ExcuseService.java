package com.symbolit.excuses.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symbolit.excuses.api.v1.model.entity.Excuse;
import com.symbolit.excuses.api.v1.model.repository.ExcuseRepository;
import com.symbolit.excuses.api.v1.model.transit.ExcuseDTO;

@Service
public class ExcuseService {
	
	@Autowired
	ExcuseRepository excuseRepository;
	
	public List<Excuse> list() {
		return excuseRepository.findAll();
	}

	public List<Excuse> saveAll(List<ExcuseDTO> excuses) {
		return excuseRepository.saveAll(
			excuses.
			stream()
			.map(e -> new Excuse(e.getHttpCode(), e.getTag(), e.getMessage()))
			.collect(Collectors.toList())
		);
	}
}