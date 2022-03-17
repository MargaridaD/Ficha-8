package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Andar")
public class Andar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @OneToMany(mappedBy = "andar")
    private List<Loja> listaLojas;
    
    @ManyToOne()
    @JoinColumn(name = "centro_comercial_id", nullable = false)
    @JsonIgnore
    private CentroComercial centro_comercial;
     
    public int numero_andar;
	public int numero_maximo_lojas;
	public Long getId() {
		return id;
	}
	public List<Loja> getListaLojas() {
		return listaLojas;
	}
	public void setListaLojas(List<Loja> listaLojas) {
		this.listaLojas = listaLojas;
	}
	public CentroComercial getCentro_comercial() {
		return centro_comercial;
	}
	public void setCentro_comercial(CentroComercial centro_comercial) {
		this.centro_comercial = centro_comercial;
	}
	public int getNumero_andar() {
		return numero_andar;
	}
	public void setNumero_andar(int numero_andar) {
		this.numero_andar = numero_andar;
	}
	public int getNumero_maximo_lojas() {
		return numero_maximo_lojas;
	}
	public void setNumero_maximo_lojas(int numero_maximo_lojas) {
		this.numero_maximo_lojas = numero_maximo_lojas;
	}
	
    public void addLoja(Loja loja){
        listaLojas.add(loja);
    }

    public void removeLoja(Loja loja){
        listaLojas.remove(loja);
    }


	
	

 
}
