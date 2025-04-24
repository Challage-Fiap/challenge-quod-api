package br.com.fiap.challenge.quod.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {
    private String fabricante;
    private String modelo;
    private String sistemaOperacional;
}