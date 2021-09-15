package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.domain.ClienteDomain;

/*
 * ENTIDADE CATEGORIA:
 * VALIDAÇÕES SITATICAS
 * Nome mão pode ser vazio
 * Nome deve conter entre 5 a 80 caracteres
 * 
 * */

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max =120, message= "O tamanho deve serentre 5 e 120 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail invalido")
	private String email;
	
	
	
	
	public ClienteDTO() {
		
	}


	public ClienteDTO(ClienteDomain cliente) {
		this.id =cliente.getId();
		this.nome =cliente.getNome();
		this.email =cliente.getEmail();
	}

	public ClienteDTO(Integer id,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 5, max = 80, message = "O tamanho deve serentre 5 e 80 caracteres") String nome,
			String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
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



	
	
	
}
