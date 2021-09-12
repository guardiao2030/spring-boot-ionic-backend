package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.*;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public CategoriaDomain find(Integer id) {
		Optional<CategoriaDomain> obj =repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+ id + ", Tipo : "+ CategoriaDomain.class.getName()));
	}
	
	public CategoriaDomain insert(CategoriaDomain obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public CategoriaDomain update(CategoriaDomain obj) {
		// TODO Auto-generated method stub
		find(obj.getId());
		return repo.save(obj);
	}
	
}
