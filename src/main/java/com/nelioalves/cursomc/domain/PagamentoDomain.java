package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.nelioalves.cursomc.domain.enums.EstadoPagamentoEnum;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PagamentoDomain  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name= "pedido_id")
	@MapsId
	private PedidoDomain pedido;
	
	public PagamentoDomain() {
		
	}

	public PagamentoDomain(Integer id, EstadoPagamentoEnum estado, PedidoDomain pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamentoEnum getEstado() {
		return EstadoPagamentoEnum.toEnum(estado);
	}

	public void setEstado(EstadoPagamentoEnum estado) {
		this.estado = estado.getCod();
	}

	public PedidoDomain getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDomain pedido) {
		this.pedido = pedido;
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
		PagamentoDomain other = (PagamentoDomain) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

