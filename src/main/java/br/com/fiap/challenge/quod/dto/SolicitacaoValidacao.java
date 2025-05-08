package br.com.fiap.challenge.quod.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoValidacao {

    private String imagemBase64;
    private String tipoBiometria;
    private String tipoDocumento;
    private LocalDateTime dataCaptura;
    private DispositivoDTO dispositivo;
    private Metadados metadados;
    private Boolean biometriaValida;

    
}
