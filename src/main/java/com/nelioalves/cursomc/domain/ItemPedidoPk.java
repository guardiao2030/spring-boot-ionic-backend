package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPk implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne 
	@JoinColumn(name="pedido_id")
	private PedidoDomain pedido;
	@ManyToOne 
	@JoinColumn(name="produto_id")
	private ProdutosDomain produto;
	
	public PedidoDomain getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDomain pedido) {
		this.pedido = pedido;
	}
	public ProdutosDomain getProduto() {
		return produto;
	}
	public void setProduto(ProdutosDomain produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPk other = (ItemPedidoPk) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}
	
	
	
}
