package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LojaService;

@RestController
public class LojaController {
	private final LojaService lojaService;
	
	@Autowired
	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}

}
