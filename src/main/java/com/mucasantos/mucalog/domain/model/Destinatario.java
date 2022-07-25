package com.mucasantos.mucalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Destinatario {

	@Column(name = "destinatario_nome")
	private String nome;
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	@Column(name = "destinatario_numero")
	private String numeroString;
	@Column(name = "destinatario_complemento")
	private String complemento;
	@Column(name = "destinatario_bairro")
	private String bairro;
	@Column(name = "destinatario_cidade")
	private String cidade;
	@Column(name = "destinatario_estado")
	private String estado;
	@Column(name = "destinatario_cep")
	private String cep;
	
	
	
	public Destinatario(String nome, String logradouro, String numeroString, String complemento, String bairro,
			String cidade, String estado, String cep) {
		super();
		this.nome = nome;
		this.logradouro = logradouro;
		this.numeroString = numeroString;
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
	public String getNumeroString() {
		return numeroString;
	}
	public void setNumeroString(String numeroString) {
		this.numeroString = numeroString;
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
