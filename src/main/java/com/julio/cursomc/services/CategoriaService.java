package com.julio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.cursomc.domain.Categoria;
import com.julio.cursomc.repositories.CategoriaRepository;

//notação Jpa que indica se tratar de um service
@Service
public class CategoriaService {
	
	//Notação JPA que instancia o objeto repo por injeção de dependencia
	@Autowired
	private CategoriaRepository repo;
	
	//método criado para localizar uma categoria através de um id. Retorna o objeto Categoria se achar e null caso não encontre no BD.
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
