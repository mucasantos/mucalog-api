package com.mucasantos.mucalog.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mucasantos.mucalog.domain.repository.ClienteRepository;
import com.mucasantos.mucalog.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
		
	}
	

	@GetMapping("/{clienteId}")
	ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		
		
		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
		
	}		
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar (@Valid @RequestBody Cliente cliente) {
	
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar (@PathVariable Long clienteId, 
		@Valid	@RequestBody Cliente cliente){
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("{clienteId}")
	public ResponseEntity<Void> delete(@PathVariable Long clienteId){
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		 clienteRepository.deleteById(clienteId);
		 
		 return ResponseEntity.noContent().build();
	}
}


