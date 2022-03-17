package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Andar;

public class SimpleResponseAndar  extends SimpleResponse{
	List<Andar> andares;

	public SimpleResponseAndar() {
		andares = new ArrayList<>();
	}

	public List<Andar> getAndares() {
		return andares;
	}

	public void setAndares(List<Andar> andares) {
		this.andares = andares;
	}
	
	

}
