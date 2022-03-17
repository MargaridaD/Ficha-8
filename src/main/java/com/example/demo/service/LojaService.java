package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AndarRepository;
import com.example.demo.repository.LojaRepository;



@Service
public class LojaService {
    private final LojaRepository lojaRepo;
	private final AndarRepository andarRepo;
	
	 @Autowired
	public LojaService(LojaRepository lojaRepo, AndarRepository andarRepo) {
		super();
		this.lojaRepo = lojaRepo;
		this.andarRepo = andarRepo;
	}
	
	
	 
}
