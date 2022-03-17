package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "centro_comercial")
public class CentroComercial {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @OneToMany(mappedBy = "centro_comercial")
    private List<Andar> listaAndares;

    private String nome;
    private String morada;
    private int numero_max_andar;
    
	public Long getId() {
		return id;
	}
	public List<Andar> getListaAndares() {
		return listaAndares;
	}
	public void setListaAndares(List<Andar> listaAndares) {
		this.listaAndares = listaAndares;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public int getNumero_max_andar() {
		return numero_max_andar;
	}
	public void setNumero_max_andar(int numero_max_andar) {
		this.numero_max_andar = numero_max_andar;
	}
    public void addAndar(Andar andar){
        listaAndares.add(andar);
    }
    public void removePessoa(Andar andar){
    	listaAndares.remove(andar);
    }

   
}
