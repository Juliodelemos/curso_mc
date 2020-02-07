package com.julio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julio.cursomc.domain.Categoria;
import com.julio.cursomc.domain.Produto;
import com.julio.cursomc.repositories.CategoriaRepository;
import com.julio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	//cria uma dependencia com Depository, pois é esta camada que sabe acessar o BD
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//Este método é da CommandLineRunner (vem apenas a assinatura,cabe ao desenvolvedor desenvolver o conteúdo do método
	@Override
	public void run(String... args) throws Exception {
		
		//--------------------Criação de 2 objetos, conforme o Diagrama de Objetos
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		//--------------------Criação de 3 objetos, conforme o Diagrama de Objetos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		//--------------------Criando as instâncias de relacionamento entre Categoria e Produto
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//--------------------chama o método da categoriaRepository e produtoRepository capaz de salvar os dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

	
}
