package br.com.fiap.challenge.quod.service;

import br.com.fiap.challenge.quod.dto.NotificacaoFraudeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class SimulacaoEnvioQUODService {

    // URL do sistema da QUOD para onde vamos enviar os dados (exemplo)
    @Value("${quod.api.url}")
    private String quodApiUrl;

    private final RestTemplate restTemplate;

    public SimulacaoEnvioQUODService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Simula o envio de uma notificação de fraude para o sistema da QUOD.
     * 
     * @param notificacaoFraudeDTO Dados da notificação de fraude.
     * @return String com a resposta da simulação de envio.
     */
    public String simularEnvioNotificacao(NotificacaoFraudeDTO notificacaoFraudeDTO) {
        try {
            // Aqui, estamos apenas fazendo uma requisição POST para o sistema da QUOD.
            String url = String.format("%s/registrar-fraude", quodApiUrl);
            HttpStatusCode status = restTemplate.postForEntity(url, notificacaoFraudeDTO, String.class).getStatusCode();

            if (status == HttpStatus.OK) {
                return "Notificação de fraude enviada com sucesso para o sistema da QUOD.";
            } else {
                return "Falha ao enviar a notificação para o sistema da QUOD. Status: " + status;
            }
        } catch (HttpClientErrorException e) {
            return "Erro ao simular envio para o sistema da QUOD: " + e.getMessage();
        }
    }
}
