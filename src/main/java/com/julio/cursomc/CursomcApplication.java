package com.julio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julio.cursomc.domain.Categoria;
import com.julio.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	//cria uma dependencia com Depository, pois é esta camada que sabe acessar o BD
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//Este método é da CommandLineRunner (vem apenas a assinatura,
	//cabe ao desenvolvedor desenvolver o conteúdo do método
	@Override
	public void run(String... args) throws Exception {
		//Criação de 2 objetos, conforme o Diagrama de Objetos
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//chama o método da categoriaRepository capaz de salvar os dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
			
	}

	
	
}
