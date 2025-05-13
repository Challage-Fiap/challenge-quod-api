package br.com.fiap.challenge.quod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.challenge.quod.dto.ResultadoValidacao;
import br.com.fiap.challenge.quod.dto.SolicitacaoValidacao;
import br.com.fiap.challenge.quod.model.RegistroValidacao;
import br.com.fiap.challenge.quod.reposiroy.RegistroValidacaoRepository;

@Service
public class BiometriaDigitalService {

    @Autowired
    private ValidacaoImagemService validacaoImagemService;

    @Autowired
    private RegistroValidacaoRepository registroRepository;

    public ResultadoValidacao validarEProcessarSolicitacao(SolicitacaoValidacao solicitacao) {
        boolean valido = solicitacao.getBiometriaValida() != null && solicitacao.getBiometriaValida();
        String tipoFraude = null;

        if (!valido) {
            if (!validacaoImagemService.imagemBase64EhValida(solicitacao.getImagemBase64())) {
                tipoFraude = "Imagem inválida ou corrompida";
            } else if (!validacaoImagemService.metadadosValidos(solicitacao)) {
                tipoFraude = "Metadados incompletos ou inconsistentes";
            } else {
                valido = true;
            }
        } else {
            tipoFraude = "Biometria validada localmente";
        }

        ResultadoValidacao resultado = new ResultadoValidacao(valido, tipoFraude,
                valido ? "Validação bem-sucedida" : "Erro na validação");

        RegistroValidacao registro = RegistroValidacao.from(solicitacao, resultado);
        if (!valido || tipoFraude != null) {
            registroRepository.save(registro);
        }

        return resultado;
    }
}
