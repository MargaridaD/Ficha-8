package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Loja;

public class SimpleResponseLoja  extends SimpleResponse{
	List<Loja> lojas;

	public SimpleResponseLoja(List<Loja> lojas) {
		lojas = new ArrayList<>();
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}
}
