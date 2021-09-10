package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PedidoDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instante;
	
	/// mapeamento um para um aula numero 26 da seção 1
	// mapeia mesmo ida do pedico com o mesmo id do pagamento "pedido" é o mesmo nome da variavel
	// na classe pagamento
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "pedido")
	private PagamentoDomain pagamento;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private ClienteDomain cliente;
	
	@ManyToOne
	@JoinColumn(name="endereca_de_entrega_id")
	private EnderecoDomain enderecoDeEntrega;
	
	public PedidoDomain() {
	
	}

	public PedidoDomain(Integer id, Date instante, ClienteDomain cliente,
			EnderecoDomain enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public PedidoDomain(Integer id, Date instante, PagamentoDomain pagamento, ClienteDomain cliente,
			EnderecoDomain enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public PagamentoDomain getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoDomain pagamento) {
		this.pagamento = pagamento;
	}

	//@JsonIgnore
	public ClienteDomain getCliente() {
		return cliente;
	}

	
	public void setCliente(ClienteDomain cliente) {
		this.cliente = cliente;
	}

	public EnderecoDomain getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(EnderecoDomain enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
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
		PedidoDomain other = (PedidoDomain) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
