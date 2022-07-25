package com.mucasantos.mucalog.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mucasantos.mucalog.domain.model.Cliente;
import com.mucasantos.mucalog.domain.model.Entrega;
import com.mucasantos.mucalog.domain.model.StatusEntrega;
import com.mucasantos.mucalog.domain.repository.EntregaRepository;

@Service
public class SolicitaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private CadastroClienteService clienteService;

		
	public SolicitaEntregaService(EntregaRepository entregaRepository) {
		super();
		this.entregaRepository = entregaRepository;
	}



	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		
		entrega.setStatusEntrega(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		
		return entregaRepository.save(entrega);
	}
}
