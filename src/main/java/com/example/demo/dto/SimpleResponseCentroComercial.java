package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.CentroComercial;

public class SimpleResponseCentroComercial extends SimpleResponse {
	private CentroComercial centroComercial;

	public CentroComercial getCentroComercial() {
		return centroComercial;
	}

	public void setCentroComercial(CentroComercial centroComercial) {
		this.centroComercial = centroComercial;
	}
}
