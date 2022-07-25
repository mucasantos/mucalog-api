package com.mucasantos.mucalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mucasantos.mucalog.domain.exception.NegocioException;
import com.mucasantos.mucalog.domain.model.Cliente;
import com.mucasantos.mucalog.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	private ClienteRepository clienteRepository;

	public CadastroClienteService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	
	public Cliente buscar(Long clienteID) {
		
		return clienteRepository.findById(clienteID)
				.orElseThrow(()-> new NegocioException("Cliente não encontrado"));	
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch((clienteExistente -> !clienteExistente.equals(cliente)));
				
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir (Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
