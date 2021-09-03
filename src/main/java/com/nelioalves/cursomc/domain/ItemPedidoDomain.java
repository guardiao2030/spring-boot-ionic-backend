package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

//@Entity
public class ItemPedidoDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedidoDomain(){
		
	}

	public ItemPedidoDomain(Double desconto, Integer quantidade, Double preco) {
		super();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	
}
