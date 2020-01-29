package com.julio.cursomc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julio.cursomc.domain.Categoria;
import com.julio.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//Notação responsável por instanciar o obj service
	@Autowired
	private CategoriaService service;
	
	//value="/{id} acrescenta /id à url, para permitir: /categoria/1
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	//ResponseEntity<?> é um objeto complexo que carrega consigo informações necessárias ao 
	//protocolo HTTP.  A <?> informa que aceita qualquer objeto (pode retornar null)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}

}
