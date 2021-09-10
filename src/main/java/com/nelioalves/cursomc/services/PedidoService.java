package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.PedidoDomain;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.*;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public PedidoDomain buscar(Integer id) {
		Optional<PedidoDomain> obj =repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+ id + ", Tipo : "+ PedidoDomain.class.getName()));
	}
	
}
