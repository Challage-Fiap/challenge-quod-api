package br.com.fiap.challenge.quod.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificacoes_fraude")
public class NotificacaoFraude {

    @Id
    private String id;
    private String transacaoId;
    private String tipoBiometria;
    private String tipoFraude;
    private LocalDateTime dataCaptura;
    private String dispositivo;
    private String canalNotificacao;
    private String notificadoPor;
    private Metadados metadados;
    private LocalDateTime dataNotificacao;

    
}
