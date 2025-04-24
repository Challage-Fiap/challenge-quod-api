package br.com.fiap.challenge.quod.service.impl;


import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.model.Validacao;
import br.com.fiap.challenge.quod.reposiroy.ValidacaoRepository;
import br.com.fiap.challenge.quod.service.ValidacaoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class BiometriaFacialService implements ValidacaoImagemService {

    @Autowired
    private ValidacaoRepository validacaoRepository;

    @Override
    public boolean validarImagemBase(String imagemBase64) {
        if (imagemBase64 == null || imagemBase64.isEmpty()) return false;

        try {
            byte[] decoded = Base64.getDecoder().decode(imagemBase64);
            return decoded.length > 10000; // Simula tamanho mínimo
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
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

        // Criando o objeto de resultado
        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setValido(valido);
        resultado.setTipoFraude(tipoFraude);
        resultado.setMensagem(valido ? "Validação bem-sucedida" : "Erro na validação");

        // Persistindo a validação no MongoDB
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

