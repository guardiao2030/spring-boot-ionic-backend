package com.nelioalves.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.dto.ClienteNewDTO;
import com.nelioalves.cursomc.resources.exception.FieldMessage;
import com.nelioalves.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		if(objDto.getTipoCliente().equals( 
				TipoCliente.PESSOAFISICA.getCod())
				&& ! BR.isValidCPF(objDto.getCpfouCnpj()))
			list.add(new FieldMessage("cpfouCnpj", "CPF Inválido"));
		
		if(objDto.getTipoCliente().equals( 
				TipoCliente.PESSOAJURIDICA.getCod())
				&& ! BR.isValidCNPJ(objDto.getCpfouCnpj()))
			list.add(new FieldMessage("cpfouCnpj", "CNPF Inválido"));

		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}