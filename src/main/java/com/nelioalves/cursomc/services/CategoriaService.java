package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}

	public List<CategoriaDomain> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public Page<CategoriaDomain> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);	
	}
	
}
