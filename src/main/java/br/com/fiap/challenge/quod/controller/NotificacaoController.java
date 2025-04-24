package br.com.fiap.challenge.quod.controller;

import br.com.fiap.challenge.quod.dto.NotificacaoFraudeDTO;
import br.com.fiap.challenge.quod.model.Metadados;
import br.com.fiap.challenge.quod.model.NotificacaoFraude;
import br.com.fiap.challenge.quod.reposiroy.NotificacaoFraudeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoFraudeRepository notificacaoFraudeRepository;

    @PostMapping("/fraude")
    public ResponseEntity<String> notificarFraude(@RequestBody NotificacaoFraudeDTO notificacaoFraudeDTO) {
        NotificacaoFraude notificacao = new NotificacaoFraude();
        notificacao.setTransacaoId(notificacaoFraudeDTO.getTransacaoId());
        notificacao.setTipoBiometria(notificacaoFraudeDTO.getTipoBiometria());
        notificacao.setTipoFraude(notificacaoFraudeDTO.getTipoFraude());
        notificacao.setDataCaptura(notificacaoFraudeDTO.getDataCaptura());
        notificacao.setDispositivo(notificacaoFraudeDTO.getDispositivo().getModelo());
        notificacao.setCanalNotificacao(String.join(", ", notificacaoFraudeDTO.getCanalNotificacao()));
        notificacao.setNotificadoPor(notificacaoFraudeDTO.getNotificadoPor());
        
        notificacao.setDataNotificacao(LocalDateTime.now());
        
        Metadados metadados = new Metadados(notificacaoFraudeDTO.getMetadados().getLatitude(), notificacaoFraudeDTO.getMetadados().getLongitude(), notificacaoFraudeDTO.getMetadados().getIpOrigem());
        notificacao.setMetadados(metadados);
        notificacaoFraudeRepository.save(notificacao);


        return ResponseEntity.ok("Notificação de fraude registrada com sucesso.");
    }
}
