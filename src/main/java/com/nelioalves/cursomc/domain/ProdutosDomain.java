package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ProdutosDomain  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
	           joinColumns = @JoinColumn(name = "produto_id"),
	           inverseJoinColumns = @JoinColumn(name = "categoria_id")
			  )
	private List<CategoriaDomain> categorias = new ArrayList<>(); 
	
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedidoDomain> itens = new HashSet<>();
	
	public ProdutosDomain() {}

	public ProdutosDomain(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	
	// monta uma lista de produtos  (pedidos )
	public List<PedidoDomain> getPedidos(){
		List<PedidoDomain> lista = new ArrayList<>();
		for (ItemPedidoDomain x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	@JsonIgnore
	public List<CategoriaDomain> getCategoria() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDomain> categoria) {
		this.categorias = categoria;
	}

	public Set<ItemPedidoDomain> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoDomain> itens) {
		this.itens = itens;
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
		ProdutosDomain other = (ProdutosDomain) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
