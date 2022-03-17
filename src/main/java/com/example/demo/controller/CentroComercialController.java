package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.SimpleResponseCentroComercial;
import com.example.demo.model.CentroComercial;
import com.example.demo.service.CentroComercialService;
import com.example.demoAula.model.Empresa;


@RestController
public class CentroComercialController {
	
	private final CentroComercialService centroComercialService;
	
	@Autowired
	public CentroComercialController(CentroComercialService centroComercialService) {
		this.centroComercialService = centroComercialService;
	}
	
	@PostMapping("/addCentroComercial")
    public ResponseEntity<SimpleResponse> addCentroComercial(@RequestBody CentroComercial cc){
        SimpleResponseCentroComercial sr = new SimpleResponseCentroComercial();

        if (cc.getNome() == null || cc.getNome().isBlank()){
            sr.setMessage("Nome Invalido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sr);
        }
        
        if (cc.getMorada() == null || cc.getMorada().isBlank()){
            sr.setMessage("Morada Inválida");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sr);
        }
        
        if (cc.getNumero_max_andar() <=0){
            sr.setMessage("Nuúmero Máximo de Andares Inválido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sr);
        }
                
        if (centroComercialService.addCentroComercial(cc)){
            sr.setAsSuccess("Centro Comercial Inserido Com Sucesso");
            sr.setCentroComerciais(centroComercialService.getCentrosComerciais());

        }else{
            sr.setAsError("Erro ao inserir a Centro Comercial");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sr);
    }
	
    @DeleteMapping("/deleteCentroComercial/{id}")
    public SimpleResponse removeCentroComercial (@PathVariable String id){
        SimpleResponse sr = new SimpleResponse();

        if (centroComercialService.removeCentroComercial(id)){
            sr.setAsSuccess("Centro Comercial Removido Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover Centro Comercial");
        }
        return sr;
    }
    
    @GetMapping("/getAllCentroComercial")
    public List<CentroComercial> getAllCentrosComerciais(){
        return centroComercialService.getAllCentrosComerciais();
    }
	
	
}
