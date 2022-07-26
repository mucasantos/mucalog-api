package com.mucasantos.mucalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mucasantos.mucalog.api.model.EntregaModel;
import com.mucasantos.mucalog.api.model.input.EntregaInputModel;
import com.mucasantos.mucalog.domain.model.Entrega;

@Component
public class EntregaAssembler {
	
	private ModelMapper modelMapper;

	public EntregaAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	
	public EntregaModel toModel(Entrega entrega) {
		
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	
	public Entrega toEntity(EntregaInputModel entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}

/*
 * 
 * Responsável de converter de um tipo para outro
 */
