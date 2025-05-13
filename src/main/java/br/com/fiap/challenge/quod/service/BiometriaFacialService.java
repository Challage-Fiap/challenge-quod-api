package br.com.fiap.challenge.quod.service;


import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.model.Validacao;
import br.com.fiap.challenge.quod.reposiroy.ValidacaoRepository;

@Service
public class BiometriaFacialService {

    @Autowired
    private ValidacaoRepository validacaoRepository;

    public boolean validarImagemBase(String imagemBase64) {
        if (imagemBase64 == null || imagemBase64.isEmpty()) return false;

        try {
            byte[] decoded = Base64.getDecoder().decode(imagemBase64);
            return decoded.length > 10000;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean simularFraude(String imagemBase64) {
        return imagemBase64.contains("deepfake") || imagemBase64.contains("foto_falsa");
    }

    public ResultadoValidacao validarBiometriaFacial(SolicitacaoValidacao solicitacao) {
        boolean valido = validarImagemBase(solicitacao.getImagemBase64());
        String tipoFraude = null;

        if (!valido) {
            tipoFraude = "Imagem inválida";
        } else {
            tipoFraude = simularFraude(solicitacao.getImagemBase64()) ? "Fraude detectada" : null;
        }

        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setValido(valido);
        resultado.setTipoFraude(tipoFraude);
        resultado.setMensagem(valido ? "Validação bem-sucedida" : "Erro na validação");

        Validacao validacao = new Validacao(
                "facial",
                solicitacao.getImagemBase64(),
                valido,
                tipoFraude,
                resultado.getMensagem(),
                LocalDateTime.now(),
                solicitacao.getDispositivo().getFabricante(),
                solicitacao.getDispositivo().getModelo(),
                solicitacao.getDispositivo().getSistemaOperacional(),
                solicitacao.getMetadados().getLatitude(),
                solicitacao.getMetadados().getLongitude(),
                solicitacao.getMetadados().getIpOrigem()
        );

        validacaoRepository.save(validacao);

        return resultado;
    }
}

