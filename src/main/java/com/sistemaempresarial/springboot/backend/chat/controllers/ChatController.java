package com.sistemaempresarial.springboot.backend.chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.sistemaempresarial.springboot.backend.chat.models.documents.Mensagem;
import com.sistemaempresarial.springboot.backend.chat.models.service.ChatService;

@Controller
public class ChatController {

	private String[] cores = {"red", "green", "blue", "magenta", "purple", "orange"};
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private SimpMessagingTemplate websocket;
	
	@MessageMapping("/mensagem")
	@SendTo("/chat/mensagem")
	public Mensagem recebeMensagem(Mensagem mensagem) {
		mensagem.setData(new Date().getTime());
		if(mensagem.getTipo().equals("NOVO_USUARIO")) {
			mensagem.setCor(cores[new Random().nextInt(cores.length)]);
			mensagem.setTexto("novo usuario");		
		}else {
			chatService.guardar(mensagem);
		}
		return mensagem;
	}

	@MessageMapping("/escrevendo")
	@SendTo("/chat/escrevendo")
	public String estaEscrevendo(String username) {
		return username.concat(" está escrevendo...");
	}
	
	@MessageMapping("/historico")
	public void historico(String clienteId){
		websocket.convertAndSend("/chat/historico/" + clienteId,chatService.obterUltimas10Mensagens());
			}
}
