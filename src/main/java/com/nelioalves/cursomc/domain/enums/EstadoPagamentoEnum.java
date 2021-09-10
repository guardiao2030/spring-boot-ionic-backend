package com.nelioalves.cursomc.domain.enums;

public enum EstadoPagamentoEnum {
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int cod;
	private String descrição;
	
	private EstadoPagamentoEnum(int cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}
	
	public static EstadoPagamentoEnum toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for( EstadoPagamentoEnum x : EstadoPagamentoEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido: " + cod);
	}
	

}
