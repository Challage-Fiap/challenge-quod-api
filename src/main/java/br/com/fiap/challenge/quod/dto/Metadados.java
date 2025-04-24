package br.com.fiap.challenge.quod.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadados {

    private String fabricante;
    private String modelo;
    private String sistemaOperacional;
    private double latitude;
    private double longitude;
    private String ipOrigem;
}
