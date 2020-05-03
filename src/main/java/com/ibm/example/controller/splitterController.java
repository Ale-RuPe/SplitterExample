package com.ibm.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.example.model.Operation;
import com.ibm.example.service.SplitterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class splitterController {
	@Autowired
	SplitterService service;
	
	@PostMapping(path ="${api.controller.uri}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void splitRequest(@RequestBody Operation jsonObj){
		
		log.info("request param: {}", jsonObj);
		service.splitOperation(jsonObj);
	}
}
