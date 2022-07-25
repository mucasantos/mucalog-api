package com.mucasantos.mucalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Destinatario {

	@NotBlank
	@Column(name = "destinatario_nome")
	private String nome;
	
	@NotBlank
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name = "destinatario_numero")
	private String numero;
	
	@NotBlank
	@Column(name = "destinatario_complemento")
	private String complemento;
	
	@NotBlank
	@Column(name = "destinatario_bairro")
	private String bairro;
	
	@NotBlank
	@Column(name = "destinatario_cidade")
	private String cidade;
	
	@NotBlank
	@Column(name = "destinatario_estado")
	private String estado;
	
	@NotBlank
	@Column(name = "destinatario_cep")
	private String cep;
	
	public Destinatario() {}
	
	public Destinatario(String nome, String logradouro, String numeroString, String complemento, String bairro,
			String cidade, String estado, String cep) {
		super();
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numeroString;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numeroString) {
		this.numero = numeroString;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
