package com.mucasantos.mucalog.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mucasantos.mucalog.domain.model.Entrega;
import com.mucasantos.mucalog.domain.service.SolicitaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitaEntregaService solicitaEntregaService;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega ) {
		
		return solicitaEntregaService.solicitar(entrega);
	}
	
}
