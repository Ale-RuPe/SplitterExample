package com.ibm.example.service;

import com.ibm.example.model.Transference;

public interface RouterBancoService {
	void forwardTo(Transference b,String origen);
}
