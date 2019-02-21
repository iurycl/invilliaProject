package com.invillia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.classe.Loja;
import com.invillia.repository.LojaRepository;

@Service
public class LojaService {

		@Autowired
		LojaRepository lojaRepository;
		
		/*salvar loja*/
		public Loja save(Loja lj) {
			return lojaRepository.save(lj);
			
		}
		
		/*buscar loja*/
		
		public List<Loja> findAll(){
			return lojaRepository.findAll();
		}
	
		/*get loja pelo codigo*/
		
		public Loja findOne(Long ljid) {
			return lojaRepository.findOne(ljid);
		}
		
		/*delete loja*/
		
		public void delete(Loja lj) {
			lojaRepository.delete(lj);
		}
		
		
		
		
}
