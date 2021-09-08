package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public ClienteDomain buscar(Integer id) {
		Optional<ClienteDomain> obj =repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+ id + ", Tipo : "+ ClienteDomain.class.getName()));
	}
	
}
