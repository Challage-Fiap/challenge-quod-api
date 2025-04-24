package br.com.fiap.challenge.quod.reposiroy;


import br.com.fiap.challenge.quod.model.Validacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacaoRepository extends MongoRepository<Validacao, String> {
}
