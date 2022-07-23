package com.mucasantos.mucalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String motivo;
	private List<Campo> campos;
	
public static class Campo {
		
		private String nome;
		public Campo(String string, String string2) {
			
			this.nome = string;
			this.mensagem = string2;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		private String mensagem;
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
	}
	
	
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime localDateTime) {
		this.dataHora = localDateTime;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	
}
