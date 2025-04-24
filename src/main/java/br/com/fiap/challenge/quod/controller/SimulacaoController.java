package br.com.fiap.challenge.quod.controller;

import br.com.fiap.challenge.quod.dto.NotificacaoFraudeDTO;
import br.com.fiap.challenge.quod.service.SimulacaoEnvioQUODService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulacoes")
public class SimulacaoController {

    @Autowired
    private SimulacaoEnvioQUODService simulacaoEnvioQUODService;

    @PostMapping("/envio-fraude")
    public ResponseEntity<String> simularEnvioFraude(@RequestBody NotificacaoFraudeDTO notificacaoFraudeDTO) {
        // Chama o serviço para simular o envio da notificação de fraude para o sistema da QUOD
        String resultado = simulacaoEnvioQUODService.simularEnvioNotificacao(notificacaoFraudeDTO);

        // Retorna o resultado da simulação
        return ResponseEntity.ok(resultado);
    }
}
