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
@Document(collection = "analise_documento")
public class Documento {
    @Id
    private String id;
    private String transacaoId;
    private String imagemBase64;
    private LocalDateTime dataCaptura;
    private Dispositivo dispositivo;
    private Metadados metadados;
    private boolean fraudeDetectada;
    private String tipoFraude;
}

