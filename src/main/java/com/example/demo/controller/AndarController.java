package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AndarService;

@RestController
public class AndarController {
	private final AndarService andarService;
	
	@Autowired
	public AndarController(AndarService andarService) {
		this.andarService = andarService;
	}

}
