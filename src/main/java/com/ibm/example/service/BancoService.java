package com.ibm.example.service;

import com.ibm.example.model.Transference;

public interface BancoService {
	void transfer(Transference tranference, String origin);
}
