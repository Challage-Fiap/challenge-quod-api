package br.com.fiap.challenge.quod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.service.DocumentoService;

@RestController
@RequestMapping("/api/validacao/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/validar")
    public ResponseEntity<ResultadoValidacao> validarDocumento(@RequestBody SolicitacaoValidacao solicitacao) {
        boolean valido = documentoService.validarImagemBase(solicitacao.getImagemBase64());
        String tipoFraude = null;

        if (!valido) {
            tipoFraude = "Documento inválido";
        } else {
            tipoFraude = documentoService.simularFraude(solicitacao.getImagemBase64()) ? "Fraude detectada" : null;
        }

        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setValido(valido);
        resultado.setTipoFraude(tipoFraude);
        resultado.setMensagem(valido ? "Validação bem-sucedida" : "Erro na validação");

        return ResponseEntity.ok(resultado);
    }
}
