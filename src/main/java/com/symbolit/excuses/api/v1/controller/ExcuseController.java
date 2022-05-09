package com.symbolit.excuses.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;


import com.symbolit.excuses.api.v1.model.entity.Excuse;
import com.symbolit.excuses.api.v1.service.ExcuseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
@RequestMapping("/api/v1/excuses")
public class ExcuseController {
	
	@Autowired
	ExcuseService execuseService;
	
	@GetMapping 
	@ApiOperation(value = "List of all excuses",notes= "returns a list of excuses", response = Excuse.class)
	public ResponseEntity<List<Excuse>> load() {
		return ResponseEntity.ok(execuseService.list());
	}
	
	@GetMapping ("/{httpCode}")
	@ApiOperation(value = "Excuse by http code",notes= "This returns an excuse based on an http code, you need to supply http code as path variable", response = Excuse.class)
	public ResponseEntity<Excuse> load(@PathVariable  @NonNull int httpCode) {
		if(execuseService.findByHttpCode(httpCode).isPresent()) {
			return ResponseEntity.ok(execuseService.findByHttpCode(httpCode).get());
		} 
		
		return ResponseEntity.notFound().build();
	}

}
