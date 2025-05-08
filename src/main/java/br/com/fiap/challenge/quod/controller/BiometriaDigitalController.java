package br.com.fiap.challenge.quod.controller;

import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.service.ValidacaoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validacao/digital")
public class BiometriaDigitalController {

    @Autowired
    private ValidacaoImagemService biometriaDigitalService;

    @PostMapping("/validar")
    public ResponseEntity<ResultadoValidacao> validarBiometriaDigital(@RequestBody SolicitacaoValidacao solicitacao) {
        boolean valido = solicitacao.getBiometriaValida();
        String tipoFraude = null;

        if (!valido) {
            tipoFraude = "Imagem inválida";
        } else {
            tipoFraude = "Biometria valida";
        }

        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setValido(valido);
        resultado.setTipoFraude(tipoFraude);
        resultado.setMensagem(valido ? "Validação bem-sucedida" : "Erro na validação");

        return ResponseEntity.ok(resultado);
    }
}
