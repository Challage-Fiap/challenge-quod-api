package br.com.fiap.challenge.quod.service.impl;

import java.util.Base64;

import org.springframework.stereotype.Service;

import br.com.fiap.challenge.quod.service.ValidacaoImagemService;

@Service
public class BiometriaDigitalService implements ValidacaoImagemService {

    @Override
    public boolean validarImagemBase(String imagemBase64) {
        if (imagemBase64 == null || imagemBase64.isEmpty()) return false;

        try {
            byte[] decoded = Base64.getDecoder().decode(imagemBase64);
            return decoded.length > 8000; // Simula tamanho mínimo
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean simularFraude(String imagemBase64) {
        return imagemBase64.contains("dedo_fake") || imagemBase64.contains("scanner_digital");
    }
}
