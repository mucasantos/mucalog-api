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
	
	
	private ModelMapper modelMapper;
	
	
	public EntregaController(SolicitaEntregaService solicitaEntregaService, EntregaRepository entregaRepository,
			ModelMapper modelMapper) {
		super();
		this.solicitaEntregaService = solicitaEntregaService;
		this.entregaRepository = entregaRepository;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega ) {
		
		return solicitaEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar(){
		return entregaRepository.findAll();
	}
	
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar (@PathVariable Long entregaId) {
		
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaModel entregaModel = modelMapper.map(entrega, EntregaModel.class);
					
					return ResponseEntity.ok(entregaModel);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
