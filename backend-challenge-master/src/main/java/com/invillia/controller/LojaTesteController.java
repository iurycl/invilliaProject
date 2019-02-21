package com.invillia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.classe.Loja;
import com.invillia.service.LojaService;

@RestController
@RequestMapping(value="/lojaTeste", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
public class LojaTesteController {

	@Autowired
	LojaService lojaService;
	
	/* salvar a loja*/
	@PostMapping("/novaLoja")
	public Loja criarLoja(@Valid @RequestBody Loja lj) {
		return lojaService.save(lj);
	}


}















