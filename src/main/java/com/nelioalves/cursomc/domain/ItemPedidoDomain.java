package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedidoDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk id =new ItemPedidoPk();
	
	public ItemPedidoDomain(){
		
	}

	public ItemPedidoDomain(PedidoDomain pedido, ProdutosDomain produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
	}

	public ItemPedidoPk getId() {
		return id;
	}

	public void setId(ItemPedidoPk id) {
		this.id = id;
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
	
	@JsonIgnore
	public PedidoDomain getPedido() {
		return this.id.getPedido();
	}
	//@JsonIgnore
	public ProdutosDomain getProduto() {
		return this.id.getProduto();
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
		ItemPedidoDomain other = (ItemPedidoDomain) obj;
		return Objects.equals(id, other.id);
	}
	
}
