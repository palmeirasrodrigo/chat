package com.sistemaempresarial.springboot.backend.chat.models.service;

import java.util.List;

import com.sistemaempresarial.springboot.backend.chat.models.documents.Mensagem;

public interface ChatService {
	public List<Mensagem> obterUltimas10Mensagens();
	public Mensagem guardar(Mensagem mensagem);
}
