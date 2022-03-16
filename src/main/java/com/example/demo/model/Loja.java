package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Loja")
public class Loja {
	
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "andar_id", nullable = false)
    @JsonIgnore
    private Andar andar;
	
	
	public String nome;
	public int numero_funcionarios;
	public int area;
	public Long getId() {
		return id;
	}

	public Andar getAndar() {
		return andar;
	}
	public void setAndar(Andar andar) {
		this.andar = andar;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero_funcionarios() {
		return numero_funcionarios;
	}
	public void setNumero_funcionarios(int numero_funcionarios) {
		this.numero_funcionarios = numero_funcionarios;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
}
