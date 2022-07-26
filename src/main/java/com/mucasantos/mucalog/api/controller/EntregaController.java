package com.mucasantos.mucalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mucasantos.mucalog.api.assembler.EntregaAssembler;
import com.mucasantos.mucalog.api.model.EntregaModel;
import com.mucasantos.mucalog.domain.model.Entrega;
import com.mucasantos.mucalog.domain.repository.EntregaRepository;
import com.mucasantos.mucalog.domain.service.SolicitaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitaEntregaService solicitaEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	
	private EntregaAssembler entregaAssembler;
	
	

	public EntregaController(SolicitaEntregaService solicitaEntregaService, EntregaRepository entregaRepository,
			EntregaAssembler entregaAssembler) {
		super();
		this.solicitaEntregaService = solicitaEntregaService;
		this.entregaRepository = entregaRepository;
		this.entregaAssembler = entregaAssembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody Entrega entrega ) {
		
		return entregaAssembler.toModel( solicitaEntregaService.solicitar(entrega) );
	}
	
	@GetMapping
	public List<EntregaModel> listar(){
		return entregaAssembler.toCollectionModel( entregaRepository.findAll() );
	}
	
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar (@PathVariable Long entregaId) {
		
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					
					return ResponseEntity.ok(entregaAssembler.toModel(entrega));
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
