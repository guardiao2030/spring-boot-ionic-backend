package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nelioalves.cursomc.domain.enums.TipoCliente;


@Entity
public class ClienteDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfouCnpj;
	// tipo enum - enumerado , "classe" de constantes pré-definidas. 
	private Integer tipoCliente;
	


	//libera a serialização (mostra a lista)
	//@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List <EnderecoDomain> enderecos = new ArrayList<>();
	
	//gera uma coleção que não permite repetiçõe de elementos
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();

	//libera a serialização (mostra a lista)
	//@JsonManagedReference
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<PedidoDomain> pedidos = new ArrayList<>();
	
	
	
	public ClienteDomain() {
		
	}
	public ClienteDomain(Integer id, String nome, String email, String cpfouCnpj, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfouCnpj = cpfouCnpj;
		this.tipoCliente = tipoCliente==null? null : tipoCliente.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfouCnpj() {
		return cpfouCnpj;
	}

	public void setCpfouCnpj(String cpfouCnpj) {
		this.cpfouCnpj = cpfouCnpj;
	}

	public TipoCliente getTipoCliente() {
		return  TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}
	
	//@JsonIgnore
	public List<EnderecoDomain> getEnderecos() {
		return enderecos;
	}

	//@JsonIgnore
	public void setEnderecos(List<EnderecoDomain> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	//@JsonIgnore
	public List<PedidoDomain> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoDomain> pedidos) {
		this.pedidos = pedidos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDomain other = (ClienteDomain) obj;
		return Objects.equals(id, other.id);
	}
	/*
	@Override
	public String toString() {
		return "ClienteDomain []";
	}
	*/
	
}
