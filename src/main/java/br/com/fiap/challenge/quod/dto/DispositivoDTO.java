package br.com.fiap.challenge.quod.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoDTO {

    private String fabricante;
    private String modelo;
    private String sistemaOperacional;

}
