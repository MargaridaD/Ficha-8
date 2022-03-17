package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repository.AndarRepository;
import com.example.demo.repository.CentroComercialRepository;
import com.example.demo.repository.LojaRepository;

@Service
public class AndarService {
    private final CentroComercialRepository centroComercialRepo;
    private final LojaRepository lojaRepo;
	private final AndarRepository andarRepo;
	
	 @Autowired
	public AndarService(LojaRepository lojaRepo, AndarRepository andarRepo, CentroComercialRepository centroComercialRepo) {
		this.centroComercialRepo = centroComercialRepo;
		this.lojaRepo = lojaRepo;
		this.andarRepo = andarRepo;
	}

	
}
