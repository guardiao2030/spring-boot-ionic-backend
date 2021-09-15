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
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.cursomc.domain.CidadeDomain;
import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.domain.EnderecoDomain;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.dto.ClienteNewDTO;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.services.exceptions.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
		
	@Autowired
	private EnderecoRepository enderecoRepository;

	public ClienteDomain find(Integer id) {
		Optional<ClienteDomain> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo : " + ClienteDomain.class.getName()));
	}

	@Transactional
	public ClienteDomain insert(ClienteDomain obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um cliente com pedidos - e endereço");
		}
	}

	public List<ClienteDomain> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Page<ClienteDomain> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public ClienteDomain fromDTO(ClienteDTO objDto) {
		return new ClienteDomain(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public ClienteDomain fromDTO (ClienteNewDTO objDto) {
			ClienteDomain  newCliente = 
					new ClienteDomain(
							null,
							objDto.getNome(),
							objDto.getEmail(),
							objDto.getCpfouCnpj(),
							TipoCliente.toEnum(objDto.getTipoCliente()));
			
			CidadeDomain newCidade= new CidadeDomain(objDto.getCidadeId(), null, null);
			
			EnderecoDomain newEndereco = 
					new EnderecoDomain(
							null,
							objDto.getLogradouro(),
							objDto.getNumero(), 
							objDto.getComplemento(), 
							objDto.getBairro(), 
							objDto.getCep(),
							newCliente,
							newCidade);
			
			newCliente.getEnderecos().add(newEndereco);
			newCliente.getTelefones().add(objDto.getTelefone1());
			
			if(objDto.getTelefone2()!=null)
				newCliente.getTelefones().add(objDto.getTelefone2());
			
			if(objDto.getTelefone3()!=null)
				newCliente.getTelefones().add(objDto.getTelefone3());
			
			return newCliente;
	}

}
