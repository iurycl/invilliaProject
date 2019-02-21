package com.invillia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.classe.Loja;
import com.invillia.service.LojaService;

@RestController
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	LojaService lojaService;
	
	/* salvar a loja*/
	@PostMapping("/novaLoja")
	public Loja criarLoja(@Valid @RequestBody Loja lj) {
		return lojaService.save(lj);
	}
	
	/* Pegar todas as lojas*/
	@GetMapping("/lojas")
	public List<Loja> getAllLojas(){
		return lojaService.findAll();
	}
	
	/*Pegar loja pelo codigo*/
	@GetMapping("/lojas/{id}")
	public ResponseEntity<Loja> getLojaById(@PathVariable(value="id") Long ljid){
		Loja lj = lojaService.findOne(ljid);
		
		if(lj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(lj);
	}
	
	
	/* update loja */
	@PutMapping("/lojas/{id}")
	public ResponseEntity<Loja> updateLoja(@PathVariable(value="id")Long ljid, @Valid @RequestBody Loja ljDetalhes){
		Loja lj = lojaService.findOne(ljid);
		if(lj == null) {
			return ResponseEntity.notFound().build();
		}
		
		lj.setNome(ljDetalhes.getNome());
		lj.setEndereco(ljDetalhes.getEndereco());
		
		Loja updateLoja =  lojaService.save(lj);
		return ResponseEntity.ok().body(updateLoja);
		
	}
	
	/* Deletar loja*/
	@DeleteMapping("/lojas/{id}")
	public ResponseEntity<Loja> deleteLoja(@PathVariable(value="id")Long ljid){
		Loja lj = lojaService.findOne(ljid);
		if(lj == null) {
			return ResponseEntity.notFound().build();
		}
		
		lojaService.delete(lj);
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	


}
