package com.ibm.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.example.model.Operation;
import com.ibm.example.service.ChooseBancoService;
import com.ibm.example.service.SplitterService;

@Service
public class SplitterServiceImpl implements SplitterService{	
	@Autowired 
	ChooseBancoService service;
	
	@Override
	public void splitOperation(Operation operation) {	
		String origen = operation.getOrigen();
		
		operation.getTransferencias()
		.stream()
		.forEach(t -> service.chooseBanco(t, origen));
	}

}
