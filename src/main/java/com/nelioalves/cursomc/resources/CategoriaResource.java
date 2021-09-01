package com.nelioalves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {

	/*@RequestMapping(method=RequestMethod.GET)
	public List <CategoriaDomain> listar() {
	CategoriaDomain obj = service.buscar(id);
	
	CategoriaDomain cat1 = new CategoriaDomain(1,"Informática");
	CategoriaDomain cat2 = new CategoriaDomain(1,"Escritório");
	
	List <CategoriaDomain> lista = new ArrayList<>();
	
	lista.add(cat1);
	lista.add(cat2);
    }*/

	@Autowired
	private CategoriaService service; 
	
	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){	
		
		CategoriaDomain obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
