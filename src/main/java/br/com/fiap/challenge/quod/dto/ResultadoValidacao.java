package br.com.fiap.challenge.quod.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoValidacao {

    private boolean valido;
    private String tipoFraude;
    private String mensagem;
}
