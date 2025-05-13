package br.com.fiap.challenge.quod.service;

import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.stereotype.Service;

import br.com.fiap.challenge.quod.dto.DispositivoDTO;
import br.com.fiap.challenge.quod.dto.MetadadosDTO;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;

@Service
public class ValidacaoImagemService {

    public boolean imagemBase64EhValida(String imagemBase64) {
        if (imagemBase64 == null || imagemBase64.isEmpty()) return false;
        try {
            byte[] decoded = Base64.getDecoder().decode(imagemBase64);
            return decoded.length > 10000;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean metadadosValidos(SolicitacaoValidacao solicitacao) {
        if (solicitacao.getDataCaptura() == null || solicitacao.getDataCaptura().isAfter(LocalDateTime.now())) {
            return false;
        }

        DispositivoDTO disp = solicitacao.getDispositivo();
        if (disp == null || disp.getFabricante() == null || disp.getModelo() == null) {
            return false;
        }

        MetadadosDTO meta = solicitacao.getMetadados();
        if (meta != null && meta.getIpOrigem() != null &&
            !meta.getIpOrigem().matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
            return false;
        }

        return true;
    }
}

