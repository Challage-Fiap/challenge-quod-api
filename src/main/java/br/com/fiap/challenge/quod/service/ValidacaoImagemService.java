package br.com.fiap.challenge.quod.service;

public interface ValidacaoImagemService {

	boolean validarImagemBase(String imagemBase64);
    
	boolean simularFraude(String imagemBase64);
}

