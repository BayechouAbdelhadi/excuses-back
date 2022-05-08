package com.symbolit.excuses.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symbolit.excuses.api.v1.model.entity.Excuse;
import com.symbolit.excuses.api.v1.service.ExcuseService;

@RestController
@Controller
@RequestMapping("/api/v1/excuses")
public class ExcuseController {
	
	@Autowired
	ExcuseService execuseService;
	
	@GetMapping 
	public ResponseEntity<List<Excuse>> load() {
		return ResponseEntity.ok(execuseService.list());
	}

}
