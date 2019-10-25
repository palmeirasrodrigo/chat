package com.sistemaempresarial.springboot.backend.chat.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaempresarial.springboot.backend.chat.models.dao.ChatRepository;
import com.sistemaempresarial.springboot.backend.chat.models.documents.Mensagem;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatRepository chatDao;
	
	@Override
	public List<Mensagem> obterUltimas10Mensagens() {
		return chatDao.findFirst10ByOrderByDataDesc();
	}

	@Override
	public Mensagem guardar(Mensagem mensagem) {
		return chatDao.save(mensagem);
	}

}
