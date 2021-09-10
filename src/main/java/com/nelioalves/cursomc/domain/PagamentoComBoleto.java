package com.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelioalves.cursomc.domain.enums.EstadoPagamentoEnum;

@Entity
public class PagamentoComBoleto extends PagamentoDomain {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataVendimento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPagamento;
	
	public PagamentoComBoleto () {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamentoEnum estado, PedidoDomain pedido,Date dataVendimento,Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataVendimento = dataVendimento;
		this.dataPagamento = dataPagamento;
		
	}

	public Date getDataVendimento() {
		return dataVendimento;
	}

	public void setDataVendimento(Date dataVendimento) {
		this.dataVendimento = dataVendimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
}
