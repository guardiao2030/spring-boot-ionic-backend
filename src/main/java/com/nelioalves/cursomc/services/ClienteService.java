package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public ClienteDomain find(Integer id) {
		Optional<ClienteDomain> obj =repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+ id + ", Tipo : "+ ClienteDomain.class.getName()));
	}

	public ClienteDomain insert(ClienteDomain obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public ClienteDomain update(ClienteDomain obj) {
		// TODO Auto-generated method stub
		ClienteDomain newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(ClienteDomain newObj, ClienteDomain obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());	
		newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um cliente com pedidos - e endereço");
		}
	}

	public List<ClienteDomain> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public Page<ClienteDomain> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public ClienteDomain fromDTO (ClienteDTO objDto) {
		return new ClienteDomain(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null);
	}
	
}
