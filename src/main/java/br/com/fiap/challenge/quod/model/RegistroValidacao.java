package br.com.fiap.challenge.quod.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "registros_validacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroValidacao {
    @Id
    private String id;
    private String imagemBase64;
    private String tipoBiometria;
    private String tipoDocumento;
    private LocalDateTime dataCaptura;
    private Dispositivo dispositivo;
    private Metadados metadados;
    private Boolean biometriaValida;

    private Boolean valido;
    private String tipoFraude;
    private String mensagem;

    public static RegistroValidacao from(SolicitacaoValidacao solicitacao, ResultadoValidacao resultado) {
        RegistroValidacao r = new RegistroValidacao();
        r.setImagemBase64(solicitacao.getImagemBase64());
        r.setTipoBiometria(solicitacao.getTipoBiometria());
        r.setTipoDocumento(solicitacao.getTipoDocumento());
        r.setDataCaptura(solicitacao.getDataCaptura());
        
        Dispositivo dispositivo = new Dispositivo(solicitacao.getDispositivo().getFabricante(), solicitacao.getDispositivo().getModelo(), solicitacao.getDispositivo().getSistemaOperacional());
        
        r.setDispositivo(dispositivo);
        Metadados metadados = new Metadados(solicitacao.getMetadados().getLatitude(), solicitacao.getMetadados().getLongitude(), solicitacao.getMetadados().getIpOrigem());
        
        r.setMetadados(metadados);
        r.setBiometriaValida(solicitacao.getBiometriaValida());
        r.setValido(solicitacao.getBiometriaValida());
        r.setTipoFraude(resultado.getTipoFraude());
        r.setMensagem(resultado.getMensagem());
        return r;
    }
}
