package br.com.fiap.challenge.quod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.service.BiometriaDigitalService;

@RestController
@RequestMapping("/api/validacao/digital")
public class BiometriaDigitalController {

    @Autowired
    private BiometriaDigitalService biometriaDigitalService;

    @PostMapping("/validar")
    public ResponseEntity<ResultadoValidacao> validarBiometriaDigital(@RequestBody SolicitacaoValidacao solicitacao) {
        ResultadoValidacao resultado = biometriaDigitalService.validarEProcessarSolicitacao(solicitacao);
        return ResponseEntity.ok(resultado);
    }

}
