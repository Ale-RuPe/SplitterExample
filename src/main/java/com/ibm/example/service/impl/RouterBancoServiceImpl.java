package com.ibm.example.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.example.model.Transference;
import com.ibm.example.service.BancoService;
import com.ibm.example.service.RouterBancoService;

@Service
public class RouterBancoServiceImpl implements RouterBancoService{
	@Autowired
	BancoService bancomerServiceImpl;
	
	@Autowired
	BancoService citiServiceImpl;
	
	@Autowired
	BancoService banorteServiceImpl;
	
	@Override
	public void forwardTo(Transference t, String origen) {
		Optional<BancoService> banco = getBanco(t.getBanco());
		if(banco.isPresent()) {
			banco.get().transfer(t, origen);
		}
		else {
			System.out.println("No se reconoce la transferencia:\n\t"+t);
		}
	}
	
	public Optional<BancoService> getBanco(String banco){
		Map<String, BancoService> services = new HashMap<>();
		services.put("01", bancomerServiceImpl);
		services.put("02", citiServiceImpl);
		services.put("03", banorteServiceImpl);
		
		return Optional.ofNullable(services.get(banco));
	}
}
