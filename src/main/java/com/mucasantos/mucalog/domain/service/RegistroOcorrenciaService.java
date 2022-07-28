package com.mucasantos.mucalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mucasantos.mucalog.domain.exception.NegocioException;
import com.mucasantos.mucalog.domain.model.Entrega;
import com.mucasantos.mucalog.domain.model.Ocorrencia;
import com.mucasantos.mucalog.domain.repository.EntregaRepository;

@Service
public class RegistroOcorrenciaService {
	
	
	private EntregaRepository entregaRepository;
	
	public RegistroOcorrenciaService(EntregaRepository entregaRepository) {
		super();
		this.entregaRepository = entregaRepository;
	}

/*
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		
		Entrega entrega = entregaRepository.findById(entregaId)
				.orElseThrow(()-> new NegocioException("Entrega não encontrada!"));
		
		 return entrega.adicionarOcorrencia(descricao);
	}
	
*/
}
