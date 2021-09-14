package com.nelioalves.cursomc.resources;

/*
 * ENTIDADE CATEGORIA:
 * VALIDAÇÕES SITATICAS
 * Nome mão pode ser vazio
 * Nome deve conter entre 5 a 80 caracteres
 * 
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import java.net.URI;
import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.dto.CategoriaDTO;
import com.nelioalves.cursomc.services.CategoriaService;


@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {


	@Autowired
	private CategoriaService service; 
	
	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){	
		
		CategoriaDomain obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){
		CategoriaDomain obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto,@PathVariable Integer id){
		CategoriaDomain obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		//		.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value ="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){	
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll(){	
		
		List<CategoriaDomain> list = service.findAll();
		//-> função anonima , converte uma lista para outra lista , elemento a elemento
		List<CategoriaDTO> listaDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
		
	}
	
	
	//localhost:8081/categorias/page?page=0&linesPerPage=3&direction=DESC
	@RequestMapping(value ="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "directio", defaultValue = "ASC")String directio){	
		
		Page<CategoriaDomain> list = service.findPage(page,linesPerPage, orderBy, directio);
		//-> função anonima , converte uma lista para outra lista , elemento a elemento
		Page<CategoriaDTO> listaDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listaDto);
		
	}
	
}
