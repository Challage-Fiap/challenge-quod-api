package br.com.fiap.challenge.quod.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metadados {
    private Double latitude;
    private Double longitude;
    private String ipOrigem;
}

