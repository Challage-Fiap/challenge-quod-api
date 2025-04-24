package br.com.fiap.challenge.quod.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "validacoes")
public class Validacao {

    @Id
    private String id;
    private String tipoBiometria; // Ex: "facial", "digital", "documento"
    private String imagemBase64;
    private boolean valido;
    private String tipoFraude; // Ex: "deepfake", "imagem_falsa"
    private String mensagem;
    private LocalDateTime dataCaptura;
    private String dispositivoFabricante;
    private String dispositivoModelo;
    private String dispositivoSO;
    private double latitude;
    private double longitude;
    private String ipOrigem;
    
	public Validacao(String tipoBiometria, String imagemBase64, boolean valido, String tipoFraude, String mensagem,
			LocalDateTime dataCaptura, String dispositivoFabricante, String dispositivoModelo, String dispositivoSO,
			double latitude, double longitude, String ipOrigem) {
		super();
		this.tipoBiometria = tipoBiometria;
		this.imagemBase64 = imagemBase64;
		this.valido = valido;
		this.tipoFraude = tipoFraude;
		this.mensagem = mensagem;
		this.dataCaptura = dataCaptura;
		this.dispositivoFabricante = dispositivoFabricante;
		this.dispositivoModelo = dispositivoModelo;
		this.dispositivoSO = dispositivoSO;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ipOrigem = ipOrigem;
	}
    
    

}
