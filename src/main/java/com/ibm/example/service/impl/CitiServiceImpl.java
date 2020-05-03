package com.ibm.example.service.impl;

import org.springframework.stereotype.Service;

import com.ibm.example.model.Transference;
import com.ibm.example.service.BancoService;

@Service
public class CitiServiceImpl implements BancoService{

	@Override
	public void transfer(Transference t, String o) {
		System.out.println("Transferencia de "+ o + " para "+ t.getDestino() + " hacia Citi :\n\t" + t+"\n");
	}

}
