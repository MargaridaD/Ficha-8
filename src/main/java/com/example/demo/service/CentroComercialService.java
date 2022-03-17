package com.example.demo.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Andar;
import com.example.demo.model.CentroComercial;
import com.example.demo.model.Loja;
import com.example.demo.repository.AndarRepository;
import com.example.demo.repository.CentroComercialRepository;
import com.example.demo.repository.LojaRepository;


@Service
public class CentroComercialService {
    private final CentroComercialRepository centroComercialRepo;
	private final AndarRepository andarRepo;
    private final LojaRepository lojaRepo;
	
	
	
	
	 @Autowired
	 public CentroComercialService(AndarRepository andarRepo, CentroComercialRepository centroComercialRepo, LojaRepository lojaRepo) {
		 this.centroComercialRepo = centroComercialRepo;
		 this.andarRepo = andarRepo;
		this.lojaRepo = lojaRepo;
	 }
	 
	 public boolean addCentroComercial(CentroComercial centroComercial){
		 if (centroComercial.getId() == null){
			 centroComercialRepo.save(centroComercial);
			 return true;
			 }
		 return false;
		 }
	 		
	 public List<CentroComercial> getCentrosComerciais(){
	        List<CentroComercial> listaCentrosComerciais = new ArrayList<>();

	        centroComercialRepo.findAll().forEach(listaCentrosComerciais::add);

	        return listaCentrosComerciais;
	    }
	 
    public boolean removeCentroComercial(String id){
        try {
            Long id_long = parseLong(id);

            if (id == null || id_long == NaN || centroComercialRepo.findById(id_long).isEmpty()){
                return false;
            }

            CentroComercial cc = centroComercialRepo.findById(id_long).get();
            for (Andar andarAux: cc.getListaAndares()){			//REMOVER ANDAR ANTES DE REMOVER CC									
            	for (Loja lojaAux: andarAux.getListaLojas()){	//REMOVER LOJAS ANTES DE REMOVER ANDAR
            		lojaRepo.delete(lojaAux);
            	}
            	andarRepo.delete(andarAux);
            }
               
            centroComercialRepo.delete(cc);
            return true;
	            
	        }catch (Exception e){
	        	return false;
	            }
	    }
    
    public List<CentroComercial> getAllCentrosComerciais(){
        List<CentroComercial> listaCentrosComerciais = new ArrayList<>();

        centroComercialRepo.findAll().forEach(listaCentrosComerciais::add);

        return listaCentrosComerciais;
    }
	 
	 

	 

	 
	    
}
