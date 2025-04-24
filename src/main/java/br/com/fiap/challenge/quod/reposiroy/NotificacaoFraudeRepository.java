package br.com.fiap.challenge.quod.reposiroy;

import br.com.fiap.challenge.quod.model.NotificacaoFraude;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoFraudeRepository extends MongoRepository<NotificacaoFraude, String> {
}
