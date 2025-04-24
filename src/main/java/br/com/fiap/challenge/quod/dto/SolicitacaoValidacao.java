package br.com.fiap.challenge.quod.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoValidacao {

    private String imagemBase64; // Imagem em base64
    private String tipoBiometria; // Tipo de biometria (facial, digital)
    private String tipoDocumento; // Tipo de documento (RG, CPF, etc.)
    private LocalDateTime dataCaptura; // Data da captura
    private DispositivoDTO dispositivo; // Informações do dispositivo
    private Metadados metadados;

    
}
