package br.com.fiap.challenge.quod.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoFraudeDTO {

    private String transacaoId;
    private String tipoBiometria;
    private String tipoFraude;
    private LocalDateTime dataCaptura;
    private DispositivoDTO dispositivo;
    private List<String> canalNotificacao;
    private String notificadoPor;
    private MetadadosDTO metadados;

}
