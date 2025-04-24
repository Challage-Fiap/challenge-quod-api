package br.com.fiap.challenge.quod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.service.impl.BiometriaFacialService;

@RestController
@RequestMapping("/api/validacao/facial")
public class BiometriaFacialController {

    @Autowired
    private BiometriaFacialService biometriaFacialService;

    @PostMapping("/validar")
    public ResponseEntity<ResultadoValidacao> validarBiometriaFacial(@RequestBody SolicitacaoValidacao solicitacao) {
        ResultadoValidacao resultado = biometriaFacialService.validarBiometriaFacial(solicitacao);
        return ResponseEntity.ok(resultado);
    }
}

