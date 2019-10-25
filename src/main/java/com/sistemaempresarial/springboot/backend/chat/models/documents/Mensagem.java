package com.sistemaempresarial.springboot.backend.chat.models.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mensagens")
public class Mensagem implements Serializable {

	@Id
	private String id;
	
	private String texto;
	private Long data;
	private String username;
	private String tipo;
	private String cor;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}


	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	private static final long serialVersionUID = -6015845255964135128L;

}
