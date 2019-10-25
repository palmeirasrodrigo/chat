package com.sistemaempresarial.springboot.backend.chat.models.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sistemaempresarial.springboot.backend.chat.models.documents.Mensagem;

public interface ChatRepository extends MongoRepository<Mensagem, String>{
	public List<Mensagem> findFirst10ByOrderByDataDesc();
}
