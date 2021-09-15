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

/*
 * 
{
"nome": "jonas algusto",
"email": "jonas@gmail.com",
"cpfouCnpj": "36378934377",
"tipoCliente": 1,
"telefone1": "964645819",
"telefone2": "964725819",
"logradouro": "Rua lituania",
"numero": "930",
"complemento": "Apto 203",
"cep": "n/a",
"cidadeId": 2
}
 * 
 * 
 * 
 */


public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String cpfouCnpj;
	private Integer tipoCliente; // tipo enum - enumerado , "classe" de constantes pré-definidas. 

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private String telefone1;
	private String telefone2; 
	private String telefone3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {
		
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

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}


}
